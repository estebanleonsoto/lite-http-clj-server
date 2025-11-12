(ns lite-http-clj-server.http-server-test
  (:require [clojure.test :refer :all]
            [lite-http-clj-server.http-server :refer :all])
  (:import (java.io DataInputStream ByteArrayInputStream)))

(defn create-input-stream
  "Creates a DataInputStream from a string for testing."
  [s]
  (-> s
      (.getBytes "UTF-8")
      ByteArrayInputStream.
      DataInputStream.))

(deftest test-read-line-from-stream
  (testing "Reading a simple line"
    (let [input (create-input-stream "Hello World\r\n")]
      (is (= "Hello World" (read-line-from-stream input)))))

  (testing "Reading an empty line (just \\r\\n)"
    (let [input (create-input-stream "\r\n")]
      (is (= "" (read-line-from-stream input)))))

  (testing "Reading multiple lines"
    (let [input (create-input-stream "First line\r\nSecond line\r\n")]
      (is (= "First line" (read-line-from-stream input)))
      (is (= "Second line" (read-line-from-stream input)))))

  (testing "End of stream returns nil"
    (let [input (create-input-stream "")]
      (is (nil? (read-line-from-stream input))))))

(deftest test-parse-first-line
  (testing "Parsing HTTP request first line"
    (let [result (parse "GET /hello HTTP/1.1" :first_line {})]
      (is (= "GET" (:method result)))
      (is (= "/hello" (:path result)))
      (is (= "HTTP/1.1" (:http-version result))))))

(deftest test-parse-headers
  (testing "Parsing HTTP header"
    (let [result (parse "Content-Type: application/json" :headers {})]
      (is (= "application/json" (get-in result [:headers "Content-Type"])))))

  (testing "Parsing header with colon in value"
    (let [result (parse "X-Custom: value:with:colons" :headers {})]
      (is (= "value:with:colons" (get-in result [:headers "X-Custom"]))))))


(deftest test-line-parsers
  (testing "line-parsers map contains expected keys"
    (is (contains? line-parsers :first_line))
    (is (contains? line-parsers :headers))
    (is (= 2 (count line-parsers)))))

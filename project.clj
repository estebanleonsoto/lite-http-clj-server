(defproject lite-http-clj-server "0.1.0-SNAPSHOT"
  :description "A lightweight, pure Clojure HTTP server for serverless environments"
  :url "https://github.com/estebanleonsoto/lite-http-clj-server"
  :license {:name "MIT License"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.12.3"]
                 [org.clojure/core.async "1.8.741"]]
  :repl-options {:init-ns lite-http-clj-server.http-server
                 :port 7888})
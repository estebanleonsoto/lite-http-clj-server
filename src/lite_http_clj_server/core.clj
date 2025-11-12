(ns lite-http-clj-server.core
    (:require [lite-http-clj-server.http-server :as server]))

(defn -main [& args]
      (try
        (server/start)
        (catch Exception e
          (println "Error running server:" (.getMessage e))
          (.printStackTrace e))
        (finally
          (println "Server stopped."))))
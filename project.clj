(defproject basic-clojure-web "0.1.0-SNAPSHOT"
  :description "My first test web project with Clojure"
  :plugins [[lein-ring "0.12.5"]
            [compojure "1.6.1"]]
  ; provides a handler that points to /src/my-web-project/core.clj file and function app_routes
  :ring {:handler basic-clojure-web.core/handler
         :auto-reload? true
         :auto-refresh? false}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.8.1"]
                 [hiccup "1.0.5"]
                 [compojure "1.6.2"]
                 [clj-http "3.10.2"]
                 [cheshire "5.10.0"]]
  :repl-options {:init-ns basic-clojure-web.core})

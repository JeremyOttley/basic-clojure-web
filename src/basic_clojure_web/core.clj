(ns basic-clojure-web.core
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
	    [clj-http.client :as http]
	    [cheshire.core :refer :all]
            [basic-clojure-web.view :as view]))

(defn parse-json [s]
  (cheshire.core/parse-string s true))
 
(defn api-response-vector [url]
  (let [response (http/get url {:accept :json})]
     (-> response
         :body
         parse-json
         :people)))

(def items (map :name (api-response-vector "http://api.open-notify.org/astros.json")))

; in project.clj ring points to this function
(defroutes app-routes
           (GET "/" [] (view/index items))
           (route/resources "/")
           ; if page is not found
           (route/not-found view/page-not-found))
 
;; site function creates a handler suitable for a standard website,
;; adding a bunch of standard ring middleware to app-route:
(def handler
  (handler/site app-routes))

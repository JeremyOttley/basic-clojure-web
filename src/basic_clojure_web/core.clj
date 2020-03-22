(ns basic-clojure-web.core
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [basic-clojure-web.view :as view]))
 
; in project.clj ring points to this function
(defroutes app-routes
           (GET "/" [] (view/index))
           (route/resources "/")
           ; if page is not found
           (route/not-found view/page-not-found))
 
;; site function creates a handler suitable for a standard website,
;; adding a bunch of standard ring middleware to app-route:
(def handler
  (handler/site app-routes))

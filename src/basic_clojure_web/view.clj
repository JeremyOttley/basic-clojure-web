(ns basic-clojure-web.view
  (:use hiccup.page hiccup.element))

(defn list-of-astros [items]
  (list
    [:h2 "Astronauts Currently on the ISS"]
    [:ul
      (for [i items]
        [:li i])]))
 
 (defn index [x]
  (html5
    [:html
     [:head
          (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
          (include-js "http://code.angularjs.org/1.2.3/angular.min.js")]
     ;;[:body "Welcome to My Homepage!"]]))
     [:body (list-of-astros x)]]))
 
(defn page-not-found []
  (html5
    [:html
     [:head
          (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
          (include-js "http://code.angularjs.org/1.2.3/angular.min.js")]
     [:body [:div {:class "container"}
   [:h1 {:class "info-warning"} "Page Not Found"]
   [:p "There's no requested page. "]
   (link-to {:class "btn btn-primary"} "/" "Take me to Home")]]]))



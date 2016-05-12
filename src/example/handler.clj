(ns example.handler
  (:require
   [compojure.route :as route]
   [compojure.core :refer [defroutes GET]]
   [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
   [ring.util.response :refer [response content-type]]
   [example.html :as html]))

(defn foo [] "foo")

(defroutes routes
  (GET "/" [] (html/index))
  (GET "/foo" [] (foo))
  (GET "/test" [] (-> (response "Example.")
                      (content-type "text/plain")))
  (route/not-found "<h1>Page not found</h1>"))

(def app
  (wrap-defaults #'routes site-defaults))


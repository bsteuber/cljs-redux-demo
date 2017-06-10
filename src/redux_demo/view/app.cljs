(ns redux-demo.view.app
  (:require [redux-demo.state :refer [store]]
            [redux-demo.view.joke-list :refer [joke-list]]
            [redux-demo.view.request-joke :refer [request-joke]]))

(defn header []
  [:h1 "Reagent Nodux Demo"])

(defn app []
  (let [props @store]
    [:div
     [header]
     [joke-list props]
     [request-joke props]]))

(ns redux-demo.view.app
  (:require [redux-demo.state :refer [store]]
            [redux-demo.view.joke-list :refer [joke-list]]
            [redux-demo.view.request-joke :refer [request-joke]]))

(defn header []
  [:h1 "Reagent Redux Demo"])

(defn app []
  [:div
   [header]
   [joke-list store]
   [request-joke store]])

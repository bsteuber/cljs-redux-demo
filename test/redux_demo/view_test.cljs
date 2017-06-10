(ns redux-demo.view-test
  (:require [cljs.test :refer [testing is]]
            [devcards.core :refer-macros [deftest defcard-rg]]
            [redux-demo.view.app :refer [app]]
            [redux-demo.view.joke-list :refer [disconnected-joke-list]]
            [redux-demo.view.request-joke :refer [disconnected-request-joke]]))

(defcard-rg empty-joke-list
  [disconnected-joke-list
   {:jokes []}])

(defcard-rg one-joke
  [disconnected-joke-list
   {:jokes ["You"]
    :delete-joke (fn [index]
                   (js/alert "You are deleted!"))}])

(defcard-rg request-component
  [disconnected-request-joke
   {:request-joke (fn [id]
                    (js/alert (str "Request! " id)))}])

(defcard-rg complete-app
  [app])

(ns redux-demo.view-test
  (:require [cljs.test :refer [testing is]]
            [devcards.core :refer-macros [deftest defcard-rg]]
            [redux-demo.actions :as actions]
            [redux-demo.state :as state]
            [redux-demo.view.app :refer [app]]
            [redux-demo.view.joke-list :refer [joke-list]]
            [redux-demo.view.request-joke :refer [request-joke]]))

(defcard-rg empty-joke-list
  [joke-list
   {::state/jokes []}])

(defcard-rg one-joke
  [joke-list
   {::state/jokes ["You"]
    ::actions/delete-joke (fn [index]
                            (js/alert "You are deleted!"))}])

(defcard-rg request-component
  [request-joke
   {::actions/request-joke (fn [id]
                             (js/alert (str "Request! " id)))}])

(defcard-rg complete-app
  [app])

(ns redux-demo.state
  (:require [redux-demo.actions :as actions]
            [redux-demo.core :as redux]
            [redux-demo.model :as model]))

(defmulti jokes-reducer (fn [state event]
                          (:type event)))

(defmethod jokes-reducer :default [state event]
  state)

(defmethod jokes-reducer ::actions/add-joke [state event]
  (model/add-joke state (::actions/joke event)))

(defmethod jokes-reducer ::actions/delete-joke [state event]
  (model/delete-joke state (::actions/index event)))

(def reducer
  (redux/combine-reducers
   {:jokes jokes-reducer}))

(def store
  (redux/create-store reducer))

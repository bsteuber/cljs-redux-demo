(ns redux-demo.view.joke-list
  (:require [reagent.core :as reagent]
            [redux-demo.actions :as actions]
            [redux-demo.core :as redux]
            [redux-demo.state :as state]))

(defn joke-entry [index joke delete-joke]
  ^{:key (str "joke-" index)}
  [:li
   joke
   " "
   [:button {:on-click #(delete-joke index)}
    "Delete"]])

(defn disconnected-joke-list [{:keys [delete-joke jokes]}]
  (if (seq jokes)
    [:ul
     (map-indexed
      (fn [index joke]
        (joke-entry index joke delete-joke))
      jokes)]
    [:p "No jokes there (yet)"]))

(defn state->list-props [state]
  {:jokes (:jokes state)})

(defn dispatch->list-props [dispatch]
  {:delete-joke (fn [index]
                  (dispatch (actions/delete-joke index)))})

(def joke-list
  (redux/connect {:state->props state->list-props
                  :dispatch->props dispatch->list-props}
                 disconnected-joke-list))

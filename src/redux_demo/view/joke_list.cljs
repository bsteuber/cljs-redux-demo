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

(defn joke-list [{:keys [::actions/delete-joke ::state/jokes]}]
  (if (seq jokes)
    [:ul
     (map-indexed
      (fn [index joke]
        (joke-entry index joke delete-joke))
      jokes)]
    [:p "No jokes there (yet)"]))

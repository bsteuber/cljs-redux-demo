(ns redux-demo.view.request-joke
  (:require [reagent.core :as reagent]
            [redux-demo.actions :as actions]
            [redux-demo.core :as redux]))

(defn request-joke [{:keys [::actions/request-joke]}]
  (let [state (reagent/atom "")
        on-submit (fn []
                    (let [parsed (js/parseInt @state)]
                      (when (pos? parsed)
                        (request-joke parsed)
                        (reset! state ""))))]
    (fn []
      [:div
       [:div.label [:p "Request more jokes"]]
       [:input {:value @state
                :on-change (fn [event]
                             (reset! state (-> event
                                               .-target
                                               .-value)))}]
       [:button {:on-click on-submit}
        "Request Joke with this id"]])))

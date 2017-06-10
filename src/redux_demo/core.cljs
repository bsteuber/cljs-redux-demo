(ns redux-demo.core
  (:require [reagent.core :as reagent]
            [redux-demo.util :refer [map-vals]]))

(defn transform-handler [store handler]
  (fn [& args]
    (apply swap! store handler args)))

(defn transform-handlers [store handlers]
  (map-vals (partial transform-handler store)
            handlers))

(defn create-store [init-state handlers]
  (let [store (reagent/atom init-state)
        handlers (transform-handlers store handlers)]
    (swap! store merge handlers)
    store))

(ns redux-demo.actions
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [taoensso.timbre :refer-macros [error info]]))

(defn delete-joke [index]
  {:type ::delete-joke
   ::index index})

(defn add-joke [joke]
  {:type ::add-joke
   ::joke joke})

(defn request-joke [id]
  (fn [dispatch state]
    (go
      (info "Fetching joke" id)
      (let [resp (<! (http/get (str "http://api.icndb.com/jokes/" id)
                               {:with-credentials? false}))]
        (if-let [joke (-> resp :body :value :joke)]
          (dispatch (add-joke joke))
          (error "Failed to fetch joke" id))))))

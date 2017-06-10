(ns redux-demo.state
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [redux-demo.actions :as actions]
            [redux-demo.core :as redux]
            [redux-demo.model :as model]
            [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [taoensso.timbre :refer-macros [error info]]))

(defn add-joke [state joke]
  (update state ::jokes model/add-joke joke))

(defn delete-joke [state index]
  (update state ::jokes model/delete-joke index))

(defn request-joke [{:keys [::actions/add-joke]
                     :as state}
                    id]
  (go
    (info "Fetching joke" id)
    (let [resp (<! (http/get (str "http://api.icndb.com/jokes/" id)
                             {:with-credentials? false}))]
      (if-let [joke (-> resp :body :value :joke)]
        (add-joke joke)
        (error "Failed to fetch joke" id))))
  state)

(def handlers
  {::actions/add-joke add-joke
   ::actions/delete-joke delete-joke
   ::actions/request-joke request-joke})

(def store
  (redux/create-store {} handlers))

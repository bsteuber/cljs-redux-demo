(ns redux-demo.main
  (:require [reagent.core :as reagent]
            [redux-demo.view.app :refer [app]]))

(defn ^:export run []
  (reagent/render [app]
                  (js/document.getElementById "app")))

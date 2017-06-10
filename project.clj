(defproject redux-demo "0.1.0-SNAPSHOT"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.542"]
                 [com.taoensso/timbre "4.10.0"]
                 [devcards "0.2.3"]
                 [reagent "0.6.2"]
                 [cljs-http "0.1.43"]]
  :plugins [[lein-cljsbuild "1.1.6"]
            [lein-figwheel "0.5.10"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"]
  :aliases {"dev"     ["figwheel" "dev" "devcards"]
            "release" ["cljsbuild" "once" "release"]}

  :source-paths ["src" "test"]

  :cljsbuild {:builds
              [{:id "devcards"
                :source-paths ["src" "test"]
                :figwheel {:devcards true}
                :compiler {:main       "redux-demo.all-tests"
                           :asset-path "js/compiled/devcards_out"
                           :output-to  "resources/public/js/compiled/redux_demo_cards.js"
                           :output-dir "resources/public/js/compiled/devcards_out"
                           :source-map-timestamp true}}
               {:id "dev"
                :source-paths ["src"]
                :figwheel true
                :compiler {:main       "redux-demo.main"
                           :asset-path "js/compiled/out"
                           :output-to  "resources/public/js/compiled/redux_demo.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true}}
               {:id "release"
                :source-paths ["src"]
                :compiler {:main          "redux-demo.main"
                           :asset-path    "js/compiled/out"
                           :output-to     "resources/public/js/compiled/redux_demo.js"
                           :optimizations :advanced}}]}
  :figwheel {:css-dirs ["resources/public/css"]})

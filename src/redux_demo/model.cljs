(ns redux-demo.model)

(def add-joke (fnil conj []))

(defn delete-joke [jokes index]
  (into []
        (concat (take index jokes)
                (drop (inc index) jokes))))

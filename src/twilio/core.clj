(ns twilio.core
  (:use [clojure.contrib.prxml :only [prxml]]))

(defmacro twiml-response [& verbs]
  `(with-out-str
     (prxml
      [:decl! {:version "1.1"}]
      [:Response ~@verbs])))

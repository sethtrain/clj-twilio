(defproject clj-twilio "0.1.0"
  :description "Clojure Twilio API"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]]
  :dev-dependencies [[lein-clojars "0.5.0"]
                     [swank-clojure "1.2.1"]]
  :aot [twilio.core
        twilio.voice]
  :jar-name "clj-twilio.jar")

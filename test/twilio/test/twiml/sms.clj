(ns twilio.test.twiml.sms
  (:use [twilio.twiml.sms] :reload)
  (:use [clojure.test]
        [twilio.twiml.core]))

(deftest test-sms
  (is (= (sms "I'm Hungry")
         [:Sms {} "I'm Hungry"]))
  (is (= (sms {:method "POST"} "I'm Hungry")
         [:Sms {:method "POST"} "I'm Hungry"])))

(deftest test-redirect
  (is (= (redirect "http://www.foo.com/nextInstructions")
         [:Redirect {} "http://www.foo.com/nextInstructions"]))
  (is (= (redirect {:method "POST"} "http://www.foo.com/nextInstructions")
         [:Redirect {:method "POST"} "http://www.foo.com/nextInstructions"])))

(ns twilio.test.twiml.core
  (:use [twilio.twiml.core] :reload)
  (:use [clojure.test]
        [twilio.twiml.voice]))

(deftest test-single-verb
  (is (= (hangup)
         [:Hangup])))

(deftest test-simple-verb
  (is (= (record)
         (record {})))
  (is (= (record {:timeout 1})
         [:Record {:timeout 1}])))

(deftest test-content-verb
  (is (= (say "Message")
         (say {} "Message")))
  (is (= (say "Message")
         [:Say {} "Message"]))
  (is (= (say {:voice "woman"} "Message")
         [:Say {:voice "woman"} "Message"])))

(deftest test-nested-verb
  (is (= (gather)
         [:Gather {} nil]))
  (is (= (gather (say "Message"))
         [:Gather {} (list [:Say {} "Message"])]))
  (is (= (gather {} (say "Message") (play "message.mp3"))
         [:Gather {} (list [:Say {} "Message"] [:Play {} "message.mp3"])])))

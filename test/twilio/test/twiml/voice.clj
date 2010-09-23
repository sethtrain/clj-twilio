(ns twilio.test.twiml.voice
  (:use [twilio.twiml.voice] :reload)
  (:use [clojure.test]
        [twilio.twiml.core]))

(deftest test-say
  (is (= (say "Hello World")
         [:Say {} "Hello World"]))
  (is (= (say {:voice "woman"} "Hello World")
         [:Say {:voice "woman"} "Hello World"])))

(deftest test-play
  (is (= (play "http://foo.bar.com/hello.mp3")
         [:Play {} "http://foo.bar.com/hello.mp3"]))
  (is (= (play {:loop 1} "http://foo.bar.com/hello.mp3")
         [:Play {:loop 1} "http://foo.bar.com/hello.mp3"])))

(deftest test-gather
  (is (= (gather)
         [:Gather {} nil]))
  (is (= (gather (say "Please enter your account number."))
         [:Gather {} (list [:Say {} "Please enter your account number."])]))
  (is (= (gather {} (say "Please enter your account number.")
                    (play "http://foo.bar.com/account_music.mp3"))
         [:Gather {} (list [:Say {} "Please enter your account number."]
                           [:Play {} "http://foo.bar.com/account_music.mp3"])])))

(deftest test-record
  (is (= (record)
         [:Record {}]))
  (is (= (record {:maxLength 20 :method "GET"})
         [:Record {:maxLength 20 :method "GET"}])))

(deftest test-dial-number
  (is (= (dial (number "123-555-5555"))
         [:Dial {} (list [:Number {} "123-555-5555"])]))
  (is (= (dial (number {:sendDigits "9999"} "123-555-5555"))
         [:Dial {} (list [:Number {:sendDigits "9999"} "123-555-5555"])]))
  (is (= (dial {:method "POST"} (number "123-555-5555"))
         [:Dial {:method "POST"} (list [:Number {} "123-555-5555"])])))

(deftest test-dial-conference
  (is (= (dial (conference "123-555-5555"))
         [:Dial {} (list [:Conference {} "123-555-5555"])]))
  (is (= (dial (conference {:startConferenceOnEnter "true"} "123-555-5555"))
         [:Dial {} (list [:Conference {:startConferenceOnEnter "true"} "123-555-5555"])]))
  (is (= (dial {:method "POST"} (conference "123-555-5555"))
         [:Dial {:method "POST"} (list [:Conference {} "123-555-5555"])])))

(ns twilio.twiml.voice
  (:use [twilio.twiml.core]))

;; Primary Verbs

(content-verb say)
(content-verb play)
(nestable-verb gather)
(simple-verb record)
(content-verb sms)
(nestable-verb dial)
(content-verb number)
(content-verb conference)

;; Secondary Verbs

(single-verb hangup)
(content-verb redirect)
(simple-verb reject)
(simple-verb pause)

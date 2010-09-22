(ns twilio.voice
  (:use [clojure.contrib.str-utils2 :only [capitalize]]))

(defmacro single-verb [name]
  (let [tag (keyword (capitalize (str name)))]
    `(defn ~name [] [~tag])))

(defmacro simple-verb [name]
  (let [tag (keyword (capitalize (str name)))]
    `(defn ~name
       ([]
          (~name {}))
       ([attrs#]
          [~tag attrs#]))))

(defmacro content-verb [name]
  (let [tag (keyword (capitalize (str name)))]
    `(defn ~name
       ([content#]
          (~name {} content#))
       ([attrs# content#]
          [~tag attrs# content#]))))

(defmacro nestable-verb [name]
  (let [tag (keyword (capitalize (str name)))]
    `(defn ~name
       ([]
          [~tag {} nil])
       ([nested#]
          (~name {} nested#))
       ([attrs# & nested#]
          [~tag attrs# nested#]))))

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

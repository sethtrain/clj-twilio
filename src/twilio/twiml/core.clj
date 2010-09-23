(ns twilio.twiml.core
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


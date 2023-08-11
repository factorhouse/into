(ns factorhouse.kafka.topic-test
  (:require [clojure.test :refer :all]
            [factorhouse.kafka.topic :as topic]
            [factorhouse.test.data :as data]))

;; TODO: Technical Challenge! Make the test pass.
(deftest sizes

  (is (= data/sizes
         (topic/sizes data/topics))))

;; TODO: Optional Bonus Extension!
(deftest categories

  (is (= data/categories-physical
         (topic/categories-physical data/sizes)))

  (is (= data/categories-logical
         (topic/categories-logical data/sizes))))
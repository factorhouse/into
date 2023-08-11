(ns factorhouse.test.data)

;; 'topics' holds raw data we collect from a Kafka Cluster
;;
;; It includes information about the size in bytes of a topic spread across brokers (and directories) in a Cluster
;;
;; e.g. the first line in the data below has the following semantics:
;;
;; {1           {"/kfk" {:replica-infos {{:topic "br.ch" :partition 1}  {:size 2838281 :offset-lag 0 :future? false}
;;  ^ Broker #1  ^ /kfk directory         ^ Topic 'br.ch ^ Partition #1' ^ Size in bytes
;;
;; 'topics' in this case represents an evenly (perfectly as it turns out) balanced Kafka Cluster with:
;;
;; * 3 Kafka Brokers
;; * Each Broker having a single '/kfk' directory
;; * Each Broker holding data for four topics (basically the same as a DB table in Kafka speak)
;; * Each Topic being broken into either four (two cases) or twelve (two cases) partitions
;; * Each Topic+Partition being replicated on each broker (e.g. 'br.ch', partition #1 exists on broker 1, 2, 3)
;;
;; Often we want to answer questions like:
;; How much data is on a Broker?
;; How much data is in a Topic? (either on one broker or combined across the entire cluster)
;; Is data evenly distributed throughout the partitions of a single topic?
;;
;; To achieve this goal we convert this raw data format into a more useable form ('sizes', below)
;;
;; This is the primary technical challenge. Implement the factorhouse.kafka.topic/sizes function, converting this MAP
;; into the following 'sizes' SEQUENCE and get the first test passing in factorhouse.kafka.topic-test.
;;
;; Good luck!
;;
(def topics
  {1 {"/kfk" {:replica-infos {{:topic "br.ch" :partition 1}  {:size 2838281 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 11} {:size 0 :offset-lag 0 :future? false}
                              {:topic "ad.ch" :partition 1}  {:size 0 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 0}  {:size 1960703 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 6}  {:size 3129974 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 8}  {:size 1987608 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 7}  {:size 49870302 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 5}  {:size 2952598 :offset-lag 0 :future? false}
                              {:topic "ad.ch" :partition 0}  {:size 4240523 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 3}  {:size 845405 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 3}  {:size 25225838 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 10} {:size 2663448 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 8}  {:size 34958216 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 1}  {:size 55179814 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 6}  {:size 60073954 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 10} {:size 57538887 :offset-lag 0 :future? false}
                              {:topic "br.ad" :partition 2}  {:size 3033367 :offset-lag 0 :future? false}
                              {:topic "br.ad" :partition 1}  {:size 0 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 2}  {:size 23583744 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 5}  {:size 55338430 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 9}  {:size 42982455 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 0}  {:size 36607398 :offset-lag 0 :future? false}
                              {:topic "ad.ch" :partition 2}  {:size 28094612 :offset-lag 0 :future? false}
                              {:topic "br.ad" :partition 0}  {:size 2931032 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 4}  {:size 3345116 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 4}  {:size 68260946 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 11} {:size 0 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 2}  {:size 1196556 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 7}  {:size 2206299 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 9}  {:size 2143266 :offset-lag 0 :future? false}}
              :error         "NONE"}}
   2 {"/kfk" {:replica-infos {{:topic "br.ch" :partition 1}  {:size 2838281 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 11} {:size 0 :offset-lag 0 :future? false}
                              {:topic "ad.ch" :partition 1}  {:size 0 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 0}  {:size 1960703 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 6}  {:size 3129974 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 8}  {:size 1987608 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 7}  {:size 49870302 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 5}  {:size 2952598 :offset-lag 0 :future? false}
                              {:topic "ad.ch" :partition 0}  {:size 4240523 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 3}  {:size 845405 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 3}  {:size 25225838 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 10} {:size 2663448 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 8}  {:size 34958216 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 1}  {:size 55179814 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 6}  {:size 60073954 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 10} {:size 57538887 :offset-lag 0 :future? false}
                              {:topic "br.ad" :partition 2}  {:size 3033367 :offset-lag 0 :future? false}
                              {:topic "br.ad" :partition 1}  {:size 0 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 2}  {:size 23583744 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 5}  {:size 55338430 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 9}  {:size 42982455 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 0}  {:size 36607398 :offset-lag 0 :future? false}
                              {:topic "ad.ch" :partition 2}  {:size 28094612 :offset-lag 0 :future? false}
                              {:topic "br.ad" :partition 0}  {:size 2931032 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 4}  {:size 3345116 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 4}  {:size 68260946 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 11} {:size 0 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 2}  {:size 1196556 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 7}  {:size 2206299 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 9}  {:size 2143266 :offset-lag 0 :future? false}}
              :error         "NONE"}}
   3 {"/kfk" {:replica-infos {{:topic "br.ch" :partition 1}  {:size 2838281 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 11} {:size 0 :offset-lag 0 :future? false}
                              {:topic "ad.ch" :partition 1}  {:size 0 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 0}  {:size 1960703 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 6}  {:size 3129974 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 8}  {:size 1987608 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 7}  {:size 49870302 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 5}  {:size 2952598 :offset-lag 0 :future? false}
                              {:topic "ad.ch" :partition 0}  {:size 4240523 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 3}  {:size 845405 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 3}  {:size 25225838 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 10} {:size 2663448 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 8}  {:size 34958216 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 1}  {:size 55179814 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 6}  {:size 60073954 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 10} {:size 57538887 :offset-lag 0 :future? false}
                              {:topic "br.ad" :partition 2}  {:size 3033367 :offset-lag 0 :future? false}
                              {:topic "br.ad" :partition 1}  {:size 0 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 2}  {:size 23583744 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 5}  {:size 55338430 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 9}  {:size 42982455 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 0}  {:size 36607398 :offset-lag 0 :future? false}
                              {:topic "ad.ch" :partition 2}  {:size 28094612 :offset-lag 0 :future? false}
                              {:topic "br.ad" :partition 0}  {:size 2931032 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 4}  {:size 3345116 :offset-lag 0 :future? false}
                              {:topic "br.me" :partition 4}  {:size 68260946 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 11} {:size 0 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 2}  {:size 1196556 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 7}  {:size 2206299 :offset-lag 0 :future? false}
                              {:topic "br.ch" :partition 9}  {:size 2143266 :offset-lag 0 :future? false}}
              :error         "NONE"}}})

;; This is the 'sizes' data, we use it to capture the state of a Kafka Cluster in a useable format.
;; It is exactly the same data as 'topics' translated into a SEQUENCE rather than a MAP.
;;
;; Maps are fantastic for accessing data by a key, e.g. what is the value for broker #1, topic "br.ch"
;;
;; Sequences are fantastic for re-shaping (for example sorting and partitioning), which is a valuable feature because
;; we use a javascript charting library that expects data in a different shape again (see categories-* below)
;;
(def sizes
  [{:topic "ad.ch" :partition 0 :size 4240523 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "ad.ch" :partition 1 :size 0 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "ad.ch" :partition 2 :size 28094612 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ad" :partition 0 :size 2931032 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ad" :partition 1 :size 0 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ad" :partition 2 :size 3033367 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 0 :size 1960703 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 1 :size 2838281 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 2 :size 1196556 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 3 :size 845405 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 4 :size 3345116 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 5 :size 2952598 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 6 :size 3129974 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 7 :size 2206299 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 8 :size 1987608 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 9 :size 2143266 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 10 :size 2663448 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.ch" :partition 11 :size 0 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 0 :size 36607398 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 1 :size 55179814 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 2 :size 23583744 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 3 :size 25225838 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 4 :size 68260946 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 5 :size 55338430 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 6 :size 60073954 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 7 :size 49870302 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 8 :size 34958216 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 9 :size 42982455 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 10 :size 57538887 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "br.me" :partition 11 :size 0 :offset-lag 0 :future? false :broker 1 :dir "/kfk"}
   {:topic "ad.ch" :partition 0 :size 4240523 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "ad.ch" :partition 1 :size 0 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "ad.ch" :partition 2 :size 28094612 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ad" :partition 0 :size 2931032 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ad" :partition 1 :size 0 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ad" :partition 2 :size 3033367 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 0 :size 1960703 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 1 :size 2838281 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 2 :size 1196556 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 3 :size 845405 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 4 :size 3345116 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 5 :size 2952598 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 6 :size 3129974 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 7 :size 2206299 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 8 :size 1987608 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 9 :size 2143266 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 10 :size 2663448 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.ch" :partition 11 :size 0 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 0 :size 36607398 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 1 :size 55179814 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 2 :size 23583744 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 3 :size 25225838 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 4 :size 68260946 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 5 :size 55338430 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 6 :size 60073954 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 7 :size 49870302 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 8 :size 34958216 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 9 :size 42982455 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 10 :size 57538887 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "br.me" :partition 11 :size 0 :offset-lag 0 :future? false :broker 2 :dir "/kfk"}
   {:topic "ad.ch" :partition 0 :size 4240523 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "ad.ch" :partition 1 :size 0 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "ad.ch" :partition 2 :size 28094612 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ad" :partition 0 :size 2931032 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ad" :partition 1 :size 0 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ad" :partition 2 :size 3033367 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 0 :size 1960703 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 1 :size 2838281 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 2 :size 1196556 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 3 :size 845405 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 4 :size 3345116 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 5 :size 2952598 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 6 :size 3129974 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 7 :size 2206299 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 8 :size 1987608 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 9 :size 2143266 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 10 :size 2663448 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.ch" :partition 11 :size 0 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 0 :size 36607398 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 1 :size 55179814 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 2 :size 23583744 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 3 :size 25225838 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 4 :size 68260946 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 5 :size 55338430 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 6 :size 60073954 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 7 :size 49870302 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 8 :size 34958216 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 9 :size 42982455 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 10 :size 57538887 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}
   {:topic "br.me" :partition 11 :size 0 :offset-lag 0 :future? false :broker 3 :dir "/kfk"}])

;; This is the extension technical challenge, implement the two remaining functions in the factorhouse.kafka.topic ns
;; and get the remaining two tests passing.
;;
;; Good luck again. This one is a bit trickier so if you get totally stumped don't by shy, get in touch.

;; This is the data that goes produces the first screenshot example in the README
(def categories-physical
  [{:id "0", :name 1, :size 573188772}
   {:id "0.0", :name "ad.ch", :size 32335135, :parent "0"}
   {:id "0.0.0", :name 0, :size 4240523, :parent "0.0"}
   {:id "0.0.1", :name 1, :size 0, :parent "0.0"}
   {:id "0.0.2", :name 2, :size 28094612, :parent "0.0"}
   {:id "0.1", :name "br.ad", :size 5964399, :parent "0"}
   {:id "0.1.0", :name 0, :size 2931032, :parent "0.1"}
   {:id "0.1.1", :name 1, :size 0, :parent "0.1"}
   {:id "0.1.2", :name 2, :size 3033367, :parent "0.1"}
   {:id "0.2", :name "br.ch", :size 25269254, :parent "0"}
   {:id "0.2.0", :name 0, :size 1960703, :parent "0.2"}
   {:id "0.2.1", :name 1, :size 2838281, :parent "0.2"}
   {:id "0.2.2", :name 2, :size 1196556, :parent "0.2"}
   {:id "0.2.3", :name 3, :size 845405, :parent "0.2"}
   {:id "0.2.4", :name 4, :size 3345116, :parent "0.2"}
   {:id "0.2.5", :name 5, :size 2952598, :parent "0.2"}
   {:id "0.2.6", :name 6, :size 3129974, :parent "0.2"}
   {:id "0.2.7", :name 7, :size 2206299, :parent "0.2"}
   {:id "0.2.8", :name 8, :size 1987608, :parent "0.2"}
   {:id "0.2.9", :name 9, :size 2143266, :parent "0.2"}
   {:id "0.2.10", :name 10, :size 2663448, :parent "0.2"}
   {:id "0.2.11", :name 11, :size 0, :parent "0.2"}
   {:id "0.3", :name "br.me", :size 509619984, :parent "0"}
   {:id "0.3.0", :name 0, :size 36607398, :parent "0.3"}
   {:id "0.3.1", :name 1, :size 55179814, :parent "0.3"}
   {:id "0.3.2", :name 2, :size 23583744, :parent "0.3"}
   {:id "0.3.3", :name 3, :size 25225838, :parent "0.3"}
   {:id "0.3.4", :name 4, :size 68260946, :parent "0.3"}
   {:id "0.3.5", :name 5, :size 55338430, :parent "0.3"}
   {:id "0.3.6", :name 6, :size 60073954, :parent "0.3"}
   {:id "0.3.7", :name 7, :size 49870302, :parent "0.3"}
   {:id "0.3.8", :name 8, :size 34958216, :parent "0.3"}
   {:id "0.3.9", :name 9, :size 42982455, :parent "0.3"}
   {:id "0.3.10", :name 10, :size 57538887, :parent "0.3"}
   {:id "0.3.11", :name 11, :size 0, :parent "0.3"}
   {:id "1", :name 2, :size 573188772}
   {:id "1.0", :name "ad.ch", :size 32335135, :parent "1"}
   {:id "1.0.0", :name 0, :size 4240523, :parent "1.0"}
   {:id "1.0.1", :name 1, :size 0, :parent "1.0"}
   {:id "1.0.2", :name 2, :size 28094612, :parent "1.0"}
   {:id "1.1", :name "br.ad", :size 5964399, :parent "1"}
   {:id "1.1.0", :name 0, :size 2931032, :parent "1.1"}
   {:id "1.1.1", :name 1, :size 0, :parent "1.1"}
   {:id "1.1.2", :name 2, :size 3033367, :parent "1.1"}
   {:id "1.2", :name "br.ch", :size 25269254, :parent "1"}
   {:id "1.2.0", :name 0, :size 1960703, :parent "1.2"}
   {:id "1.2.1", :name 1, :size 2838281, :parent "1.2"}
   {:id "1.2.2", :name 2, :size 1196556, :parent "1.2"}
   {:id "1.2.3", :name 3, :size 845405, :parent "1.2"}
   {:id "1.2.4", :name 4, :size 3345116, :parent "1.2"}
   {:id "1.2.5", :name 5, :size 2952598, :parent "1.2"}
   {:id "1.2.6", :name 6, :size 3129974, :parent "1.2"}
   {:id "1.2.7", :name 7, :size 2206299, :parent "1.2"}
   {:id "1.2.8", :name 8, :size 1987608, :parent "1.2"}
   {:id "1.2.9", :name 9, :size 2143266, :parent "1.2"}
   {:id "1.2.10", :name 10, :size 2663448, :parent "1.2"}
   {:id "1.2.11", :name 11, :size 0, :parent "1.2"}
   {:id "1.3", :name "br.me", :size 509619984, :parent "1"}
   {:id "1.3.0", :name 0, :size 36607398, :parent "1.3"}
   {:id "1.3.1", :name 1, :size 55179814, :parent "1.3"}
   {:id "1.3.2", :name 2, :size 23583744, :parent "1.3"}
   {:id "1.3.3", :name 3, :size 25225838, :parent "1.3"}
   {:id "1.3.4", :name 4, :size 68260946, :parent "1.3"}
   {:id "1.3.5", :name 5, :size 55338430, :parent "1.3"}
   {:id "1.3.6", :name 6, :size 60073954, :parent "1.3"}
   {:id "1.3.7", :name 7, :size 49870302, :parent "1.3"}
   {:id "1.3.8", :name 8, :size 34958216, :parent "1.3"}
   {:id "1.3.9", :name 9, :size 42982455, :parent "1.3"}
   {:id "1.3.10", :name 10, :size 57538887, :parent "1.3"}
   {:id "1.3.11", :name 11, :size 0, :parent "1.3"}
   {:id "2", :name 3, :size 573188772}
   {:id "2.0", :name "ad.ch", :size 32335135, :parent "2"}
   {:id "2.0.0", :name 0, :size 4240523, :parent "2.0"}
   {:id "2.0.1", :name 1, :size 0, :parent "2.0"}
   {:id "2.0.2", :name 2, :size 28094612, :parent "2.0"}
   {:id "2.1", :name "br.ad", :size 5964399, :parent "2"}
   {:id "2.1.0", :name 0, :size 2931032, :parent "2.1"}
   {:id "2.1.1", :name 1, :size 0, :parent "2.1"}
   {:id "2.1.2", :name 2, :size 3033367, :parent "2.1"}
   {:id "2.2", :name "br.ch", :size 25269254, :parent "2"}
   {:id "2.2.0", :name 0, :size 1960703, :parent "2.2"}
   {:id "2.2.1", :name 1, :size 2838281, :parent "2.2"}
   {:id "2.2.2", :name 2, :size 1196556, :parent "2.2"}
   {:id "2.2.3", :name 3, :size 845405, :parent "2.2"}
   {:id "2.2.4", :name 4, :size 3345116, :parent "2.2"}
   {:id "2.2.5", :name 5, :size 2952598, :parent "2.2"}
   {:id "2.2.6", :name 6, :size 3129974, :parent "2.2"}
   {:id "2.2.7", :name 7, :size 2206299, :parent "2.2"}
   {:id "2.2.8", :name 8, :size 1987608, :parent "2.2"}
   {:id "2.2.9", :name 9, :size 2143266, :parent "2.2"}
   {:id "2.2.10", :name 10, :size 2663448, :parent "2.2"}
   {:id "2.2.11", :name 11, :size 0, :parent "2.2"}
   {:id "2.3", :name "br.me", :size 509619984, :parent "2"}
   {:id "2.3.0", :name 0, :size 36607398, :parent "2.3"}
   {:id "2.3.1", :name 1, :size 55179814, :parent "2.3"}
   {:id "2.3.2", :name 2, :size 23583744, :parent "2.3"}
   {:id "2.3.3", :name 3, :size 25225838, :parent "2.3"}
   {:id "2.3.4", :name 4, :size 68260946, :parent "2.3"}
   {:id "2.3.5", :name 5, :size 55338430, :parent "2.3"}
   {:id "2.3.6", :name 6, :size 60073954, :parent "2.3"}
   {:id "2.3.7", :name 7, :size 49870302, :parent "2.3"}
   {:id "2.3.8", :name 8, :size 34958216, :parent "2.3"}
   {:id "2.3.9", :name 9, :size 42982455, :parent "2.3"}
   {:id "2.3.10", :name 10, :size 57538887, :parent "2.3"}
   {:id "2.3.11", :name 11, :size 0, :parent "2.3"}])

;; This is the data that produces the second screenshot example in the demo
(def categories-logical
  [{:id "0", :name "ad.ch", :size 97005405}
   {:id "0.0", :name 0, :size 12721569, :parent "0"}
   {:id "0.1", :name 1, :size 0, :parent "0"}
   {:id "0.2", :name 2, :size 84283836, :parent "0"}
   {:id "1", :name "br.ad", :size 17893197}
   {:id "1.0", :name 0, :size 8793096, :parent "1"}
   {:id "1.1", :name 1, :size 0, :parent "1"}
   {:id "1.2", :name 2, :size 9100101, :parent "1"}
   {:id "2", :name "br.ch", :size 75807762}
   {:id "2.0", :name 0, :size 5882109, :parent "2"}
   {:id "2.1", :name 1, :size 8514843, :parent "2"}
   {:id "2.2", :name 2, :size 3589668, :parent "2"}
   {:id "2.3", :name 3, :size 2536215, :parent "2"}
   {:id "2.4", :name 4, :size 10035348, :parent "2"}
   {:id "2.5", :name 5, :size 8857794, :parent "2"}
   {:id "2.6", :name 6, :size 9389922, :parent "2"}
   {:id "2.7", :name 7, :size 6618897, :parent "2"}
   {:id "2.8", :name 8, :size 5962824, :parent "2"}
   {:id "2.9", :name 9, :size 6429798, :parent "2"}
   {:id "2.10", :name 10, :size 7990344, :parent "2"}
   {:id "2.11", :name 11, :size 0, :parent "2"}
   {:id "3", :name "br.me", :size 1528859952}
   {:id "3.0", :name 0, :size 109822194, :parent "3"}
   {:id "3.1", :name 1, :size 165539442, :parent "3"}
   {:id "3.2", :name 2, :size 70751232, :parent "3"}
   {:id "3.3", :name 3, :size 75677514, :parent "3"}
   {:id "3.4", :name 4, :size 204782838, :parent "3"}
   {:id "3.5", :name 5, :size 166015290, :parent "3"}
   {:id "3.6", :name 6, :size 180221862, :parent "3"}
   {:id "3.7", :name 7, :size 149610906, :parent "3"}
   {:id "3.8", :name 8, :size 104874648, :parent "3"}
   {:id "3.9", :name 9, :size 128947365, :parent "3"}
   {:id "3.10", :name 10, :size 172616661, :parent "3"}
   {:id "3.11", :name 11, :size 0, :parent "3"}])

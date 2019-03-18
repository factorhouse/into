(defproject com.troy-west/into "0.1.0-SNAPSHOT"

  :description "A hurdle of the technical variety"

  :min-lein-version "2.9.0"

  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/tools.logging "0.4.1"]
                 [ch.qos.logback/logback-classic "1.2.3"]]

  :aliases {"smoke" ["do" ["clean"] ["check"] ["kibit"] ["cljfmt" "check"] ["test"]]}

  :pedantic? :warn)

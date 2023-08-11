(defproject io.factorhouse/into "1.0.0"

  :description "A hurdle of the technical variety"

  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/tools.logging "1.2.4"]
                 [ch.qos.logback/logback-classic "1.3.8"]
                 [clj-kondo "2023.07.13"]]

  :aliases {"kondo" ["run" "-m" "clj-kondo.main" "--lint" "src:test" "--parallel"]})
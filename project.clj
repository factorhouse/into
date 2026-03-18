(defproject io.factorhouse/into "1.0.0"

  :description "Factor House Coding Exercise"

  :dependencies [[org.clojure/clojure "1.12.4"]
                 [org.clojure/tools.logging "1.3.1"]
                 [ch.qos.logback/logback-classic "1.5.32"]
                 [clj-kondo "2026.01.19"]]

  :aliases {"kondo" ["run" "-m" "clj-kondo.main" "--lint" "src:test" "--parallel"]})
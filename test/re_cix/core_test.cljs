(ns re-cix.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [re-cix.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
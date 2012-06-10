(ns clojurequiz.test.models.model
  (:use myporject.models.quiz)
  (:use clojure.test))

(deftest quizlist-test
  (is (not (nil? quiz)) true))

(deftest winner?-test
  (is (winner? "a" "b" "a") true)
  (is (not(winner? "b" "a" "b")) true)
  (is (not(winner? "b" "b" "b")) true)
  )

(deftest empty-answers?-test
  (is (not(empty-answers? "a" "b" "a")) true)
  (is (not(empty-answers? "a" "a" "a")) true)
  (is (empty-answers? nil nil nil) true)
 )
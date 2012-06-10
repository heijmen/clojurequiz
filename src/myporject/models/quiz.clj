(ns myporject.models.quiz)

(def quiz [{:question "Aparte text" :answer "a" :a "Apart antwoord text" :b "antwoord b"} {:question "Testvraag3" :answer "a" :a "antwoord a" :b "antwoord b"} {:question "Testvraag4" :answer "a" :a "ahallo" :b "antwoord b"}])


(defn winner? [antwoorda antwoordb antwoordc]
  (if(and (= antwoorda (get-in quiz [0 :answer])) (= antwoordb (get-in quiz [1 :answer])) (= antwoordc (get-in quiz [2 :answer])))
    true
    false
    ))
  
(defn empty-answers? [antwoorda antwoordb antwoordc] 
   (if(or (= nil antwoorda) (= nil antwoordb) (= nil antwoordc))
     true
     false
     ))
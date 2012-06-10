(ns myporject.models.quiz)

(def quiz
  [{:question "Wie is de oprichter van facebook?" :answer "a" :a "Mark Zuckerberg" :b "Google"} {:question "Waar bevindt het hoofdkwartier van Facebook zich?" :answer "b" :a "New York" :b "Palo Alto"} {:question "Sinds wanneer is er een Nederlandstalige facebook-versie?" :answer "a" :a "2008" :b "2009"}]
  )


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
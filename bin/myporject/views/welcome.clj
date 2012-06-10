
(ns myporject.views.welcome
  (:use noir.core
        myporject.models.quiz
        hiccup.core
        hiccup.page
        hiccup.form
        myporject.views.common)
  (:require [noir.session :as session])
)


(defpartial user-fields [{:keys [answera answerb answerc]}]
   [:table#thetable
                      [:tr 
                       [:td {:colspan 2}  [:p (get-in (first quiz) [:question])]]]
                      [:tr
                       [:td (label (get-in (first quiz) [:a]) (get-in (first quiz) [:a]))]
                    
                       [:td  (radio-button "group1" answera "a")]]
                      [:tr 
                       [:td (label (get-in (first quiz) [:b]) (get-in (first quiz) [:b]))]
                       [:td (radio-button "group1" answera "b")]]
                      
                      
                      [:tr 
                       [:td {:colspan 2}  [:p (get-in (second quiz) [:question])]]]
                      [:tr
                       [:td (label (get-in (second quiz) [:a]) (get-in (second quiz) [:a]))]
                    
                       [:td  (radio-button "group2" answerb, "a")]]
                      [:tr 
                       [:td (label (get-in (second quiz) [:b]) (get-in (second quiz) [:b]))]
                       [:td (radio-button "group2" answerb, "b")]]
                      
                      
                      
                      [:tr 
                       [:td {:colspan 2}  [:p (get-in (first quiz) [:question])]]]
                      [:tr
                       [:td (label (get-in (get quiz 2) [:a]) (get-in (get quiz 2) [:a]))]
                    
                       [:td  (radio-button "group3" answerc, "a")]]
                      [:tr 
                       [:td (label (get-in (get quiz 2) [:b]) (get-in (get quiz 2) [:b]))]
                       [:td (radio-button "group3" answerc, "b")]]
                      
                      [:tr
                        [:td {:colspan 2}   (submit-button "Vul In!")]]
                      ])


(defpage [:any "/hey"] {:as quizanswers} []
    (layout
            (form-to [:post "/quizanswers"] 
                    (user-fields quizanswers)
                    
                    )))

(defpage [:post "/quizanswers"] {:as quizanswers} []
    (layout
     (if(empty-answers? (:group1 quizanswers) (:group2 quizanswers) (:group3 quizanswers))
       [:p "Vul a.u.b. alles in"]
       [:div 
        [:p "Antwoord op vraag 1 was: " (:group1 quizanswers) (if(= (:group1 quizanswers) (get-in quiz [0 :answer])) " is goed" " is fout" )] 
        [:p "Antwoord op vraag 2 was: " (:group2 quizanswers) (if(= (:group2 quizanswers) (get-in quiz [1 :answer])) " is goed" " is fout" )]
        [:p "Antwoord op vraag 3 was: " (:group3 quizanswers) (if(= (:group3 quizanswers) (get-in quiz [2 :answer])) " is goed" " is fout" )]
        (if(winner? (:group1 quizanswers) (:group2 quizanswers) (:group3 quizanswers))
          [:img {:src "img/winner.jpg"}]
          [:img {:src "img/loser.jpg"}]
          )
        ]
            )
     
     ))
                     

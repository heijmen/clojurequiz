(ns myporject.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5 include-js]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "myporject"]
               (include-css "/css/reset.css")
               (include-css "checkers.css")
               (include-js "/js/checkers.js")]
              [:body {:onload "drawDefaultBoard('damhiermaar');"}
              
                content]))

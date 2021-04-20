(ns re-cix.views
  (:require
   [re-frame.core :as re-frame]
   [re-cix.subs :as subs]
   [re-cix.events :as events]))

(defn main-panel []
  (let [name   (re-frame/subscribe [::subs/name])
        screen (re-frame/subscribe [::subs/screen])
        data   (re-frame/subscribe [::subs/data])]
    [:div#main.main.cee
     [:h1 "Hello from " @name]
     [:p (str @screen)]
     [:p (str @data)]
     [:button
      {:on-click #(re-frame/dispatch [::events/update-class "coo"])}
      "Change Color"]
     [:button
      {:on-click #(re-frame/dispatch [::events/generate-data 2 5])}
      "Generate"]]))


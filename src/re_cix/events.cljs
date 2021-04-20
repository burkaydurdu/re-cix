(ns re-cix.events
  (:require
   [re-frame.core :as re-frame]
   [re-cix.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

;; Inject-cofx can work on fx
;; fn cofx arguments
(re-frame/reg-event-fx
 ::initialize-db
 [(re-frame/inject-cofx ::screen)]
 (fn-traced [{:keys [screen]} _]
  {:db (merge db/default-db {:screen screen})}))

(re-frame/reg-fx
  ::change-class!
  (fn [obj]
    (.add (.-classList (.getElementById js/document (:id obj))) (:class obj))))

(re-frame/reg-cofx
  ::screen
  (fn [coeffects]
    (assoc coeffects :screen {:width (-> js/window .-screen .-width)
                              :height (-> js/window .-screen .-height)})))

(re-frame/reg-event-fx
  ::update-class
  (fn [_ [_ class-name]]
    {::change-class! {:id "main" :class class-name}}))

(re-frame/reg-event-db
  ::add-data
  (fn [db [_ value]]
    (update db :data conj value)))

(re-frame/reg-event-fx
  ::generate-data
  (fn [{:keys [db]} [_ idx1 idx2]]
    {:db (assoc db :generate true)
     :fx (concat (map (fn [x] [:dispatch [::add-data x]]) ((juxt inc dec) idx1))
                 (map (fn [x] [:dispatch [::add-data x]]) ((juxt inc dec) idx2)))}))

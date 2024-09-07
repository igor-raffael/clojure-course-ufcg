(require '[clojure.string :as str])

(defn roots [a b c]
  (let [D (- (* b b) (* 4.0 a c))
        root (fn [op] (/ (op (- b) (Math/sqrt D)) (* 2 a)))]
    (cond
      (neg? D) "Sem raízes reais"
      (zero? D) (format "As duas raízes reais são iguais a %.2f" (root +))
      :else (format "As duas raízes reais são %.2f e %.2f" (root +) (root -)))))

(defn -main []
  (println (apply roots (map #(Integer/parseInt %) (str/split (read-line) #" ")))))

(-main)


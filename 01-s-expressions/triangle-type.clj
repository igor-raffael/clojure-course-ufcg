(defn eh-triangulo? [a b c]
  (and (> (+ a b) c)
       (> (+ a c) b)
       (> (+ b c) a)))

(defn tipo-triangulo [a b c]
  (if (eh-triangulo? a b c)
    (cond
      (and (= a b) (= b c)) :equilátero
      (or (= a b) (= b c) (= a c)) :isósceles
      :else :escaleno)
    nil))

(defn -main []
  (println (tipo-triangulo (read) (read) (read))))

(-main)

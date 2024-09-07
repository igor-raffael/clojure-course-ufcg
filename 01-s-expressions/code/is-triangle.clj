(defn eh_triangulo [a b c]
  (and
   (< 0 a)
   (< 0 b)
   (< 0 c)
   (< a (+ b c))
   (< b (+ a c))
   (< c (+ a b))))

(defn -main []
  (println (eh_triangulo (read) (read) (read))))

(-main)


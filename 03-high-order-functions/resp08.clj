(defn soma-quadrados-de-pares [coll]
  (reduce +
          (map #(* % %)
               (filter even? coll))))

(assert (= (soma-quadrados-de-pares [0 2 4 6 8]) 120))
(assert (= (soma-quadrados-de-pares [1 3 5 7 9]) 0))
(assert (= (soma-quadrados-de-pares [0 1 2 3 4 5 6 7 8 9]) 120))
(assert (= (soma-quadrados-de-pares [-2 -4 -6 -8]) 120))
(assert (= (soma-quadrados-de-pares [16]) 256))
(assert (= (soma-quadrados-de-pares []) 0))

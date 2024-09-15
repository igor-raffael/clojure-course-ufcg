(defn somador [oper]
  (fn [coll]
    (loop [coll coll
           counter 0]
      (if (empty? coll)
        counter
        (recur (rest coll) (+ counter (oper (first coll))))))))

(def soma-cubos (somador (fn [x] (* x x x))))
(def soma-dobros (somador (fn [x] (* 2 x))))
(def soma-triplos (somador (fn [x] (* 3 x))))
(def soma (somador (fn [x] x)))
(def conta (somador (fn [_] 1)))

;; Teste para soma-cubos
(assert (= 36 (soma-cubos [1 2 3])))

;; Teste para soma-dobros
(assert (= 12 (soma-dobros [1 2 3])))

;; Teste para soma-triplos
(assert (= 18 (soma-triplos [1 2 3])))

;; Teste para soma simples
(assert (= 6 (soma [1 2 3])))

;; Teste para conta
(assert (= 3 (conta [1 2 3])))

;; Teste de recursão
(assert (= 1000000 (conta (range 1000000))))

(defn fahr-to-celc [coll]
  (map (fn [fahr] (/ (* (- fahr 32) 5) 9)) coll))

(assert (= (fahr-to-celc [-4 32 50 77 212]) '(-20 0 10 25 100)))
(assert (= (fahr-to-celc [69.8 156.2]) '(21.0 69.0)))
(assert (= (fahr-to-celc []) '()))

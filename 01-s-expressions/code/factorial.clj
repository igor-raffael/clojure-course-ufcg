(defn fatorial [n]
  (if (< n 0) "Negative number" (if (= n 0) 1 (* (fatorial (dec n)) n))))

(defn factorial [n]
  (cond
    (< n 0) "Negative number"
    (= n 0) 1
    :else (* (factorial (dec n)) n)))

(defn tail-factorial
  ([n] (tail-factorial n 1))
  ([n acc]
   (cond
     (< n 0) "Negative number"
     (= n 0) acc
     :else (tail-factorial (- n 1N) (* n acc)))))

(defn -main []
  (println (tail-factorial (Integer/parseInt (read-line)))))

(-main)

(defn echo-word [n word]
  (when (> n 0)
    (println word)
    (echo-word (dec n) word)))

(defn -main []
  (println (echo-word (Integer/parseInt (read-line)) (read-line))))

(-main)

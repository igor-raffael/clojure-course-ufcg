(defn conta [lim]
  (doseq [n (range 0 (inc lim))] (prn n)))

(print "> ")
(flush)
(conta (read))

(defn length
  ([coll] (length coll 0))
  ([coll acc]
   (if (empty? coll)
     acc
     (length (rest coll) (inc acc)))))

(defn in-range? [n x]
  (and (>= x 0) (<= x n)))

(defn value-at
  ([coll i]
   (let [len (length coll)]
     (if (in-range? len i)
       (value-at coll i 0)
       nil)))
  ([coll i acc]
   (if (= i acc)
     (first coll)
     (if (empty? coll)
       nil
       (value-at (rest coll) i (inc acc))))))

(defn index-of
  ([coll v] (index-of coll v 0))
  ([coll v i]
   (if (= v (first coll))
     i
     (if (empty? coll)
       -1
       (index-of (rest coll) v (inc i))))))

(assert (= 8 (length [\n \u \f \u \t \u \r \o])))
(assert (= 1 (length '(2024))))
(assert (= 0 (length {})))

(assert (= "l" (value-at ["l" "i" "s" "p"] 0)))
(assert (= "p" (value-at ["l" "i" "s" "p"] 3)))
(assert (= nil (value-at ["c" "l" "o" "j" "u" "r" "e"] -1)))
(assert (= nil (value-at ["c" "l" "o" "j" "u" "r" "e"] 8)))
(assert (= nil (value-at [] 0)))

(assert (= 0 (index-of ["x" "y" "z"] "x")))
(assert (= 2 (index-of ["x" "y" "z"] "z")))
(assert (= -1 (index-of ["x" "y" "z"] "a")))
(assert (= 1 (index-of ["x" "y" "y" "z"] "y")))
(assert (= -1 (index-of [] "a")))

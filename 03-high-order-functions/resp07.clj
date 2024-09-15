(require '[clojure.string :as str])

(def vowel #{"a" "e" "i" "o" "u"})

(defn ini-vogais [coll]
  (map str/lower-case
       (filter #(vowel (str/lower-case (first %))) coll)))

(assert (= (ini-vogais ["igor" "raffael"]) ["igor"]))
(assert (= (ini-vogais ["IGOR" "uSYAn"]) ["igor" "usyan"]))
(assert (= (ini-vogais ["menezes" "melo"]) []))
(assert (= (ini-vogais ["arch-linux" "#arch-linux"]) ["arch-linux"]))
(assert (= (ini-vogais []) []))


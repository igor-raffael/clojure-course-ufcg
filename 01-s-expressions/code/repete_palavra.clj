(defn repete-palavra [n palavra]
  (if (> n 0)
    (let [x (println palavra)]
      (repete-palavra (dec n) palavra)
    )
  )
)

(defn -main []
  (let [n (Integer/parseInt (read-line))
        palavra (read-line)]
    (repete-palavra n palavra)
  )
)

(-main)

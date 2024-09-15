(defn msg-rec [msg]
  (println msg)
  (msg-rec msg))

(msg-rec (read))

;O erro decorre da ausência de condição de parada - nomeadamente,
;o(s) caso(s) base(s). Assim, o código executa infinitamente,
;parando apenas quando alcança o limite pré-estabelecido da pilha
;de recursão, momento no qual o erro StackOverflowError é lançado.

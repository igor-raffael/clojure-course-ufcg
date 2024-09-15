(defn conta-rec [acc]
  (prn acc)
  (conta-rec (inc acc)))

(defn conta [] (conta-rec 0))

(conta)

;A demanda por duas funções (uma chamada 'conta' e outra 'conta-rec')
;emana da restrição do problema: 'conta' deve ter aridade nula. Desse modo,
;dado que é necessário perpetuar o estado do número a ser impresso, o que
;é feito ao passá-lo como parâmetro da chamada recursiva de 'conta-rec',
;temos uma função principal cujo propósito é inicializar o ciclo recursivo
;parametrizado da função secundária.


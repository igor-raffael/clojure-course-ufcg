(defn conta []
  (loop [acc 0]
    (prn acc)
    (recur (inc acc))))

(conta)

;O erro de stack overflow não ocorre mais por causa da forma especial
;'loop/recur', a qual aplica a otimização de recursão de cauda, assim,
;por baixo dos panos, a recursão é transformada em um laço iterativo.
;Note que, na recursão nativa, cada chamada depende das subsequentes,
;acumulando na pilha e consumindo memória com cada invocação. Por outro
;lado, no laço iterativo, reutilizamos o estado ao atualizar as variáveis
;relevantes, evitando o crescimento da pilha.

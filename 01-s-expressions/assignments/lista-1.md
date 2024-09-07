# LISTA 1

1. Explique o que você entende por s-expressões?

2. Escreva cinco exemplos de s-expressões atômicas. Não use nenhum exemplo dos fornecidos nos slides. Também não use exemplos de colegas. Todos os átomos devem ser de tipos de dados diferentes.

3. O que é uma forma no contexto de Lisp e Clojure? Qual sua relação com s-expressões?

4. Escreva três exemplos de s-expressões não atômicas que não sejam formas e três outras que sejam formas (em Clojure).

5. O que são símbolos em Lisp/Clojure? Dê exemplos de símbolos. Explore a linguagem por experimentação no REPL e descubra outros símbolos operacionais semelhantes aos de outras linguagens que você tenha estudado que sejam válidos em Clojure. Escreva uma expressão usando cada um desses símbolos que você descobrir.

6. Escreva uma sequência de s-expressões que representem a avaliação da s-expressão `(* (+ 2 5 7) (- 8 (inc 3)) 5)`, passo a passo, até que seja reduzida à s-expressão atômica equivalente. Se precisar leia a seção sobre semântica de Clojure nos slides.

7. O que são _formas especiais_ e como elas diferem das demais formas? Por que `def` em uma s-expressão como `(def a 123)` é uma forma especial e não uma simples aplicação de função? Por que `fn` precisa ser definida como uma forma especial? Por que `if` precisa ser definida como forma especial?

8. Analise o programa abaixo. Considerando as definições nas primeiras três linhas, escreva a sequência passo a passo de avaliação da última s-expressão, até que seja irredutível (ou seja, até que a computação pare). Inclua até as substituições das funções.

   ```clojure
   (defn dobro [n] (* 2 n))
   (defn triplo [n] (* 3 n))
   (defn vezes_12 [n] (dobro (dobro (triplo n))))

   (vezes_12 10)
   ```

9. No REPL, com a forma especial `fn`, crie uma função anônima (ou lambda) que receba três argumentos (`a`, `b` e `c`) que representam os três coeficientes inteiros de uma equação de 2º grau e que retorne o valor do determinante (o _delta_) da equação. Com a forma especial `def`, defina o símbolo `eq2delta` e associe-o à função anônima. Em seguida, defina a mesma função usando apenas a forma especial `defn`.

10. No REPL, experimente as formas especiais `if` e `cond`. Com elas, escreva a função `raizes` que retorne um vetor contendo as duas raízes da equação.

11. As formas especiais `print` e `println` nos permitem imprimir dados na saída (às vezes, você precisará usar também a forma especial `flush` para esvaziar o buffer de saída e garantir que o dado seja impresso no momento apropriado). Estude essas formas especiais e escreva o famoso _Hello, World!_ em Clojure, no arquivo `hello.clj`.

12. As formas especiais `read` e `read-line` permitem ler dados de entrada. E a função `Integer/parseInt` permite converter uma string em um valor inteiro. Com base nas formas especiais de entrada e saída e nas definições que você mesmo criou anteriormente, crie um pequeno programa no arquivo `eq2.clj` que leia os coeficientes `a`, `b` e `c` de uma equação do segundo grau da entrada e que imprima suas raízes. Se a equação não tiver raízes, imprima a mensagem 'sem raízes' na saída.

# Parte 2

Nos exercícios abaixo, crie as funções pedidas e crie uma função `main` de apoio que teste, usando a macro `assert` de Clojure, as funções criadas.

13. Escreva a função `eh_bissexto` que avalia se um ano passado como argumento é ou não bissexto. Lembre que um ano é bissexto se for divisível por 400 ou se for divisível por 4 e não por 100.

14. Escreva a função `eh_triangulo` que, dadas as três medidas dos lados de um triângulo, determina se o triângulo é ou não válido (pesquisa a chamada condição de existência do triângulo para saber como resolver o problema).

15. Escreva a função `tipo_triangulo` que, dadas as três medidas dos lados de um triângulo, determina o tipo de triângulo e deve retornar um _keyword_ indicando o tipo: `:equilátero`, `:isósceles` e `:escaleno`. Se as medidas não corresponderem a nenhum dos três tipos, deve retornar `nil`.

16. Escreva a função `fatorial` que, dado um número inteiro N retorna o fatorial de N. Lembre que, por definição, o fatorial de 0 e 1 é igual a 1 e que o fatorial de qualquer outro inteiro K maior que 1 é igual a K multiplicado pelo fatorial de K - 1.

   > Observação. Obviamente, esta função requer repetição que é tema que ainda não vimos (será visto nas próximas aulas). 
   > Mas nesta implementação, use recursão direta. Isso tornará o código muito simples e lhe dará um gosto da forma geral de repetições em Lisp e Clojure.

17. Escreva um programa que leia dois dados da entrada: i) um número inteiro N; e ii) uma palavra; e que imprima a palavra exatamente N vezes na saída (uma vez em cada linha). Use recursividade para esta repetição.

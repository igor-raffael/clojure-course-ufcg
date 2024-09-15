## QUESTÃO 1
A homicronicidade de uma linguagem de programação significa que o código pode ser
representado e manipulado como dado. Em linguagens cono Lisp, isso é empregrado via
s-expressões, que são a unidade fundamental de representação e memória.
Por definição, uma s-expressão pode ser de duas formas:
1. Átomo;
2. Cons cell.

Um átomo é um símbolo que representa um dado primitivo. Ele é considerado "atômico"
porque não contém s-expressões recursivamente.
Uma cons cell é a unidade fundamental de composição. Ela consistente num par ordenado
que armazena dois valores ou dois ponteiros para esses valores, que podem ser
s-expressões. Além disso, são usadas para construir estruturas de dados mais
complexas, como listas e árvores binárias, a depender da parentização e espaçamento
(não identação) no código.

## QUESTÃO 2
1618033988      | Inteiro
1.618033988     | Ponto flutuante
55/89           | Ratio
"Hello, world!" | String
true            | Boolean
print           | Símbolo
nil             | Nulidade
:else, :as      | Keyword
\*              | Operador (Função)

## QUESTÃO 3
Na computação, queremos armazenar e manipular dados de maneira eficiente.
Em Lisp e Clojure, a s-expressão é a unidade fundamental de representação de dados
e código em memória. Entretanto, para processar esses dados precisamos de formas.
Uma forma é uma s-expressão parentizada que contém uma operação/função como seu
primeiro elemento e um conjunto de argumentos subsequentes, todos separados por
espaço. Assim, quando uma s-expressão está na forma sintática (notação polonesa)
em que pode ser avaliada/executada sem erros, temos uma forma.


## QUESTÃO 4
(1 2 3 4 5)             | Lista de Inteiros
((1 2) (34) (5))        | Lista de listas de inteiro(s)
("Hello" ", " "World!") | Lista de Strings
(- 1)                   | Forma da subtração "0 - 1 = -1"
(< 1.618 3.14)          | Forma da operação relacional "1.618 < 3.14"
(inc 7)                 | Forma da função incremento "7 + 1 = 8"

## QUESTÃO 5
Em linguagens Lisp, símbolos são usados como identificadores para referenciar
(não armazenar) dados como variáveis e funções. Em tempo de execução a função
'eval' avalia o símbolo à procura do elemento associado.
Alguns exemplos de símbolos de Clojure são (+ − * /), (inc dec), (fn, def, defn),
(read read-line), (print println), (type), dentre outros.
Já alguns exemplos de usos,
user=> (inc 7)
8
user=> (+)
0
user=> (type nil)
nil
user=> (read-line)
nufuturo
"nufuturo"
user=> (def x 6)
#'user/x
user=> (defn produto \[a b\] (* a b))
#'user/produto

## QUESTÃO 6
(* (+ 2 5 7) (- 8 (inc 3)) 5)
=> (* (+ 2 5 7) (- 8 4) 5)
=> (* (+ 2 5 7) 4 5)
=> (* 14 4 5)
=> 280

## QUESTÃO 7
Em linguagens Lisp, formas são s-expressões que seguem a sintaxe necessária para sua
avaliação correta pelo sistema. Já as formas especiais são um sobjunto que têm
particularidades únicas na sua lógica de avaliação, isto é, ou podem ter efeito
colateral ou podem subverter o modus operandi da execução de modo que foge do
conceito de função matemática. Por exemplo,
- 'def' associa um símbolo a um valor, salvando internamente ou globalmente via um
'var', portanto, há efeito colateral. No exemplo (def a 123), associamos a string
'a' ao inteiro '123' internamente, de tal modo que na execução o 'eval' sempre
reconhecerá tal referência.
- 'fn' define uma nova função anônima, a qual pode ser atribuída como argumento ou
passada como um, e retorna um valor. Note que o código dentro de 'fn' não é
executado imediatamente, aplicar uma função é diferente de criar.
- 'if' realiza uma escolha condicional baseada numa expressão booleana. A depender
do resultado, ela realiza um dos dois blocos de código. Note que o 'if' subverte a
ordem aplicativa, na qual o código é executado de dentro para fora, pois precisamos
avaliar o condicional antes de executar.

## QUESTÃO 8
(defn dobro \[n\] (* 2 n))
(defn triplo \[n\] (* 3 n))
(defn vezes 12 \[n\] (dobro (dobro (triplo n))))

(vezes 12 10)
(dobro (dobro (triplo 10)))
(dobro (dobro (* 3 10)))
(dobro (dobro 30)))
(dobro ( 2 30))
(dobro 60)
120

## QUESTÃO 9
(fn \[a b c\] (- (* b b) (* 4 a c)))
(def eq2delta (fn \[a b c\] (− (* b b) (* 4 a c))))
(defn eq2delta \[a b c\] (- (* b b) (* 4 a c)))


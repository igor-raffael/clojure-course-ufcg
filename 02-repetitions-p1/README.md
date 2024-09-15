# Repetições - Parte 1

1. [Arquivo `resp01.clj`] Em linguagens de programação funcionais
   a base da repetição é, tipicamente, a recursividade. Escreva a
   função `msg-rec` que apenas imprime a string recebida como
   argumento e que, através de recursividade, repete o processo
   _ad infinitum_ (ou seja, sem nenhuma condição de parada).
   Observe que como a mensagem é a mesma, a invocação recursiva
   passará o mesmo argumento sem nenhuma mudança. No mesmo
   arquivo, adicione uma invocação à função com uma string lida
   da entrada (use `read` para ler de forma simples). Execute o
   programa com o comando `clojure -M resp01.clj` e observe o
   comportamento do programa. No mesmo arquivo, adicione um
   comentário, explicando o erro de execução que ocorre.

2. [Arquivo `resp02.clj`] Escreva a função `conta` (sem
   parâmetros) que imprime uma de forma ilimitada uma contagem
   com os números naturais, começando a partir do 0. A função
   `conta`, contudo, deve invocar uma outra função chamada
   `conta-rec` que é a forma recursiva que faz efetivamente as
   repetições. Tal como no exercício anterior, a função não deve
   ter condição de parada. Contudo, observe que a cada chamada o
   valor a ser impresso precisa ser atualizado e que, por isso, o
   valor precisa ser alterado na expressão de invocação
   recursiva. Mais uma vez, adicione uma s-expressão que invoque
   a função `conta` ao arquivo, para que a contagem possa ser
   executada. Execute o programa e observe que o erro volta a
   ocorrer. Em um comentário, explique por que precisamos de duas
   funções (uma chamada `conta` e outra `conta-rec`).

3. [Arquivo `resp03.clj`] Para fazer esta segunda versão da
   função `conta`, copie o arquivo resposta da questão anterior.
   Você só precisará editar o arquivo pra produzir sua resposta.
   O objetivo aqui é eliminar a necessidade de termos duas
   funções, usando uma única função com múltiplas aridades
   (múltiplas assinaturas, se você preferir). O exemplo
   `exemplo-01.clj` contém uma função trivial que tem duas
   aridades: i) uma com um parâmetro que retorna a soma dos
   argumentos; e ii) uma com um parâmetro que retorna o produto
   do argumento recebido por 2.  Use esse exemplo, para criar uma
   nova versão de `conta` com duas aridades: i) uma com um
   parâmetro, que será usada internamente pra fazer a
   recursividade; e ii) uma sem parâmetros que será usada como
   API da função para que possa ser invocada sem argumentos pelo
   usuário da função. Observe que, embora o código fique mais
   simples o processo resultante ainda é recursivo e tem o mesmo
   problema que os anteriores, levando ao mesmo erro em tempo de
   execução.

4. [Arquivo `resp04.clj`] Vamos resolver de vez o erro. Observe
   que as funções de contagem nas questões anteriores são todas
   funções recursivas de cauda (_tail recursion_). Isso pode ser
   observado porque a invocação recursiva é exatamente a última
   operação feita pela função. Ao concluir a execução recursiva
   não resta nenhuma operação ainda por fazer (compare isso com a
   primeira versão recursiva que fizemos pra fatorial em que a
   última operação feita é a multiplicação que precisa ser feita
   após o retorno da invocação recursiva). Toda função recursiva
   de cauda pode ser implementada usando a forma especial
   conhecida por `loop` de Clojure. A ideia é simples: ao invés
   de usarmos duas aridades na função, usaremos apenas uma: a
   externa (ou pública); e, internamente, usaremos uma
   s-expressão para delimitar exatamente o trecho em que queremos
   que haja a repetição através de recursividade. Como se fosse
   uma função anônima. Copie sua resposta da questão anterior.
   Em seguida, apague todo o corpo da função `conta` (as duas
   s-expressões das aridades). Agora, inclua uma nova s-expressão
   no lugar das que foram apagadas com os seguintes elementos: i)
   a forma especial `loop` na primeira posição; ii) na segunda,
   um vetor contendo o símbolo usado como parâmetro de recursão
   (é este parâmetro que diz o valor atual da contagem) e seu
   valor inicial (zero neste caso); iii) uma s-expressão para
   imprimir o valor da contagem; e iv) uma última s-expressão com
   a forma especial `recur` que fará a chamada recursiva (é aqui
   que a contagem é atualizada. A forma especial `recur` será bem
   semelhante à que você usou na solução anterior para a
   invocação recursiva de `conta`, apenas trocando o nome da
   função pela forma especial `recur`. Rode o programa e observe
   que não há mais erro em tempo de execução. Adicione um
   comentário ao arquivo, explicando por que motivo não há mais o
   erro.

5. [Arquivo `resp05.clj`] Façamos uma última variação de nosso
   contador básico. Desta vez, usaremos uma função da biblioteca
   de Clojure que proporciona uma _sequência_ infinita de valores
   inteiros (ou seja, é ela que faz a efetiva contagem e nós
   vamos apenas imprimir cada valor). Para isso, usaremos a
   função `range`. Inicialmente, abra um REPL Clojure (comando
   `clj`) e experimente a função diretamente. Comece digitando
   `(range 10)` (ou outros inteiros) e observe o que é produzido.
   Experimente também usar dois e três argumentos `(range 100
   200)` ou `(range 100 200 10)`. Por fim, veja o que ocorre
   quando não usa nenhum argumento `(range)` (você vai precisar
   usar `Ctrl-C` para parar a contagem, já que ela será
   ilimitada). Feito isso, estude a forma especial chamada
   `doseq` (https://clojuredocs.org/clojure.core/doseq) e escreva
   uma versão completamente nova do programa que conta
   infinitamente, usando `doseq` e `range`.

6. [Arquivo `resp06.clj`] Escreva uma variação do programa acima
   que leia um inteiro da entrada (use `read`) e que conte
   (imprima os naturais) exatamente até esse valor inteiro.
   Observe que este programa não será muito diferente do
   anterior.


## Funções de alta ordem

**Atenção**. Em todos os arquivos de resposta para as questões
abaixo, você deve incluir testes silenciosos (use `assert`) para
testar as funções.

1. [Arquivo `resp01.txt`] Explique o que significa dizer que uma
   dada linguagem de programação trata funções como entidades de
   primeira classe.

2. [Arquivo `resp02.clj`] Usando apenas as funções `first` e
   `rest` (ou `next`) e repetições baseadas em recursividade
   simples, escreva as funções abaixo especificadas. Inclua
   também `asserts` que testem as funções dadas nos vários casos
   normais e também casos limite.

   a) função `length`: que recebe uma sequência e retorna o seu
   tamanho (número de elementos contidos); obviamente, você não
   deve usar a função `count` nativa de Clojure;

   b) função `value_at`: que recebe um índice inteiro `i` e uma
   sequência e que retorna o i-ésimo elemento da sequência;

   c) função `index`: que recebe um valor `v` e uma sequência e
   que retorna o índice da primeira ocorrência de `v` na
   sequência ou `-1` caso o valor não pertença à sequência;

3. [Arquivo `resp03.clj`] Usando apenas uma recursão simples,
   `first` e `next` (ou `rest`), escreva a função de alta ordem
   `somador` que recebe uma função `operador` como argumento e
   que retorna uma função unária que, por sua vez,recebe um único
   argumento e que calcula a soma dos valores da sequência
   processados com o `operador` fornecido (dica: funções lambda
   podem receber nomes para que se possa usar recursão). É
   bastante semelhante ao que demonstrei em sala de aula, com
   essa pequena diferença de que `somador` recebe uma função como
   argumento e retorna outra função como valor resultante
   (diferente de `soma-op` que aplicava a função recebida).
   Observe que, por conta dessa diferença, você vai precisar usar
   `def` ao invés de `defn` para definir as funções desejadas. O
   arquivo `testes03.clj` fornecido incluem os testes que fizemos
   na aula passada que devem se aplicar igualmente às funções que
   você vai criar. As funções a criar são: `soma-cubos` (que soma
   os cubos dos números de uma sequência); `soma-dobros` (que
   soma os dobros dos valores de uma sequência); `soma-triplos`
   (que soma os triplos); `soma` (que soma os próprios valores da
   sequência); e `conta` (que apenas conta quantos valores há na
   sequência).

4. [Arquivo `resp04.clj`] Copie o arquivo com a resposta da
   questão anterior para `resp04.clj`. Observe que a função
   `somador`, como está escrita deve estar fazendo recursão
   simples como a que fizemos em sala de aula. Logo,
   provavelmente, não é uma recursão de cauda. Para saber se é o
   ou não, lembre que você precisa ver qual é a última operação
   realizada na função. Se for a soma que precisa ser feita
   somente depois de ter o resultado da chamada recursiva, então
   o _processo_ gerado por essa função é recursivo. E lembre, uma
   coisa é o código (ou o programa) ser recursivo e outra é o
   processo ser recursivo. Aqui, vamos confirmar que a função
   impõe um processo recursivo, fazendo uma demonstração simples:
   adicione um teste a mais ao final do arquivo em que se aplique
   a função `conta` a uma sequência com, digamos, 100.000
   elementos. Se o processo for realmente recursivo, isso deve
   dar um erro em tempo de execução (vai estourar a pilha de
   execução `StackOverflowError`). Em seguida, modifique a função
   para fazer uma recursão de cauda (para isso, sugiro usar
   `loop` e  `recur`). E para testar se funcionou, basta rodar os
   testes contidos no arquivo, incluindo o que roda em uma
   sequência de 100.000 elementos. Se você tiver escrito a função
   corretamente como uma recursão de cauda, o teste deve
   funcionar sem nenhum problema. Mas observe uma coisa: embora
   você tenha modificado uma única função, as mudanças impactarão
   todas as funções derivadas criadas a partir dela.

## Map, filter, reduce e apply

Nas questões abaixo, use `map`, `filter`, `reduce` e `apply`. Na
prática, é como efetivamente programamos as soluções desejadas.
Lembre que a forma de programar nos exercícios acima é legítima,
mas requer o domínio de programação recursiva. E, na prática, é
reservado para situações mais específicas. 

> **Atenção**. Mais uma vez, em todos os arquivos abaixo, você
> deve incluir testes silenciosos (use `assert`) para testar as
> funções.

5. [Arquivo `resp05.clj`] Copie mais uma vez o arquivo anterior
   para começar esta resposta. Mais uma vez, modifique a função
   `somador`. Desta vez, contudo, reescreva a função sem código
   recursivo, usando as funções de alta ordem da bibliteca de
   Clojure (você pode considerar para uso as funções `map`,
   `filter`, `reduce` e `apply`). Mais uma vez, execute os testes
   do arquivo. Você deve ver que todos os testes passam,
   incluindo o teste de carga maior (aquele com a sequência que
   contém 100.000 elementos). Só que desta vez não temos nem
   processo, nem código recursivo. E, mais uma vez, as mudanças
   feitas afetam todas as funções derivadas "de graça".

6. [Arquivo `resp06.clj`] Escreva a função `fahr-celsius` que
   recebe uma sequência de temperaturas em graus Fahrenheit e que
   retorna uma sequência com as temperaturas convertidas para
   graus Celsius.

7. [Arquivo `resp07.clj`] Escreva a função `ini-vogais` que
   recebe uma sequência de palavras (_strings_) e retorna uma
   lista contendo apenas as palavras iniciadas por vogais.
   Contudo, na lista resultante, as palavras devem estar apenas
   em letras minúsculas.

   > Dica, use a s-expressão `(require '[clojure.string :as
   > str])` para _importar_ a biblioteca de strings e criar um
   > _alias_ `str` para simplificar seu uso. Em seguida, você
   > poderá usar as funções da biblioteca precedendo-as com
   > `str/`. Por exemplo, você pode usar `str/lower-case`,
   > `str/join`, `str/capitalize`, etc. Consulte a documentação
   > para ver outras funções disponíveis.

8. [Arquivo `resp08.clj`] Escreva a função
   `soma-quadrados-de-pares` que retorne a soma dos quadrados dos
   valores pares de uma sequência recebida como argumento.

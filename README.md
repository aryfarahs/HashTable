# Implementação de Tabelas Hash com Comparação de Funções Hash

Este projeto implementa duas tabelas hash em Java, utilizando duas funções hash distintas, para comparar a eficiência em termos de número de colisões, tempo de inserção e busca, e distribuição das chaves na tabela atendendo os requisitos que a prof Marina pediu para o TDE3 😀

## Estrutura do Projeto

- **HashTable.java**: Classe abstrata que representa a estrutura básica da tabela hash, com métodos para inserção e busca e do tratamento de colisões.
- **HTFunction1.java**: Classe que implementa a primeira função hash baseada no método de Multiplicação Secreta.
- **HTFunction2.java**: Classe que implementa a segunda função hash baseada no método SDBM.
- **Node.java**: Classe auxiliar para armazenar elementos na tabela.
- **Main.java**: Classe principal que carrega os dados de entrada, insere e busca nas tabelas, mede o tempo e exibe um relatório comparativo entre as duas funções hash.

## Explicação dos Componentes

### Estrutura da Classe `HashTable`

- Classe abstrata, tabela possui 50 posições fixas. Cada posição da tabela é representada como uma lista para gerenciar *colisões por encadeamento*.
- Temos dois contrutores, um que o valor default é 50 e outro que podemos passar o tamanho da tabela como um parametro para definir.
- Temos metodos abstratos que serão implementados nas nossas duas tabelas com funções diferentes.

#### Método de Tratamento de Colisões

Usamos **encadeamento** para tratamento de colisões. Permite que quando várias chaves caem na mesma posição, elas sejam armazenadas em uma lista dentro dessa posição.

#### Funções Hash

1. **HTFunction1 (Multiplicative Hash)**:
   - A primeira função hash utiliza a **Multiplicative Hashing**, uma técnica que aque usa a Proporção Áurea (aproximadamente 0,6180339887) para multiplicar os caracteres da chave (todas as letras do nome) gerando um valor. Depois dividimos esses valor pelo tamanho da tabela, que será a posição final que a chave será armazenada na tabela. 
   - Exemplo de cálculo:
     ```java
     double A = 0.6180339887; //áurea
     for (char c : value.toCharArray()) {
         hash += c * A; //valor hash
     }
     ```

    - Por que escolhemos essa função? O Multiplicative Hashing é rápido e eficiente, e o uso da Proporção Áurea ajuda a distribuir os valores de forma equilibrada na tabela. Essa função é especialmente útil para chaves curtas, como nomes que foram utilizados no trabalhos.

2. **HTFunction2 (SDBM Hash)**:
   - A segunda função hash utiliza o método **SDBM**. Ele aplica operações de deslocamento e soma para gerar o índice. la faz uma série de operações de deslocamento de bits e soma/subtração para processar cada caractere da chave. Esse processo de “embaralhamento” dos valores é ótimo para minimizar colisões, principalmente quando as chaves possuem características semelhantes. Envolvem deslocamentos de bits (movendo os bits à esquerda ou à direita) e operações de adição/subtração.
   - Exemplo de cálculo:
     ```java
     for (char c : value.toCharArray()) {
         hash = c + (hash << 6) + (hash << 16) - hash;
     }
     ```
    - Por que escolhemos essa função? A SDBM Hash é muito utilizada em sistemas e bancos de dados devido à sua capacidade de espalhar valores de maneira confiável, mesmo com chaves que compartilham padrões. 

##### Explicação: 
1. Deslocamentos de Bits:

- hash << 6: Desloca os bits do valor hash 6 posições para a esquerda. Equivalente a multiplicar hash por 64.
- hash << 16: Desloca os bits do valor hash 16 posições para a esquerda. Equivalente a multiplicar hash por 65.536.
- Permite que pequenos valores de hash cresçam rapidamente. Cria uma "distância" entre os valores de hash com base nos deslocamentos, que ajuda a espalhar os resultados pela tabela.

2. Soma/Subtração:

- (hash << 6) + (hash << 16) - hash: Essa combinação cria um "embaralhamento" dos bits de hash. A subtração final evita que o valor de hash cresça linearmente ao longo do loop.

3. Adição do Caractere Atual (c):

- O valor do caractere "c" é somado ao resultado das operações anteriores. Isso faz com que cada caractere contribua com uma "parcela" única ao valor de hash, baseada em sua posição e no deslocamento acumulado dos bits.

Ambas as funções hash retornam o índice como `hash % size` para garantir que o valor fique dentro dos limites da tabela.

### Estrutura da Classe `Main`

- Lê um arquivo `female_names.txt` e armazena os nomes em uma lista `List<String>`.
   
2. **Inserção e Busca**:
   - Cada nome é inserido nas duas tabelas hash.
   - Após a inserção, mede-se o tempo necessário para inserir e buscar cada nome.
   - Foi alterado para o arquivo `HashTablePerformance.java` as funções de medição para deixar a Main mais clara

3. **Cálculo e Exibição de Tempo**:
   - O `System.nanoTime()` mede o tempo de inserção e busca de cada tabela.
   - Deixamos em segundos para facilitar, por mias que nanosegundo faça mais sentido.

## Como Compilar e Executar (vscode pelo menos)

- Compila e coloca as classes na pasta class

```bash
    javac -d class *.java
```

- Executa utilizando as classes da pasta class

```bash
    java -cp class Main  
```
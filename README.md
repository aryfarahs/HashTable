# Estrutura do Código

- **Main.java**: Classe principal que carrega os dados, insere nas tabelas hash, mede o desempenho e exibe o relatório final.
- **HashTable.java**: Classe abstrata que define a estrutura de uma tabela hash com redimensionamento dinâmico e tratamento de colisões por endereçamento linear.
- **FuncaoNormal.java**: Implementa uma função hash baseada no comprimento da string.
- **FuncaoASCII.java**: Implementa uma função hash que calcula a soma dos valores numéricos das letras da string.
- **HashTablePerformance.java**: Classe que mede o tempo de inserção e busca em cada tabela hash.

## Funcionamento do Código

### 1. Main.java

A classe principal `Main` realiza as seguintes operações:

1. **Carregamento dos Dados**: Lê o arquivo `female_names.txt`, que contém uma lista de 5001 nomes.
2. **Criação das Tabelas Hash**: Inicializa duas tabelas hash usando as classes `FuncaoNormal` e `FuncaoASCII`.
3. **Medida de Desempenho**: Utiliza a classe `HashTablePerformance` para medir o tempo de inserção e busca para cada tabela hash.
4. **Exibição dos Resultados**: Mostra no console o número de colisões, o tempo de inserção e busca, e a distribuição das chaves em cada tabela.

### 2. HashTable.java

A classe `HashTable` é abstrata e define a estrutura de uma tabela hash genérica. Suas principais responsabilidades são:

- **Tratamento de Colisões**: Utiliza endereçamento linear, ou seja, em caso de colisão, o próximo índice disponível é utilizado.
- **Redimensionamento Dinâmico**: Quando a tabela atinge 70% de ocupação (fator de carga 0.7), seu tamanho é duplicado e todos os elementos são reinseridos.
- **Método `insert`**: Insere elementos na tabela, lidando com colisões e redimensionamento.
- **Método `search`**: Realiza a busca por elementos na tabela.
- **Função Hash Abstrata**: Define a função hash como abstrata para que cada implementação (`FuncaoNormal` e `FuncaoASCII`) tenha sua própria lógica.

### 3. FuncaoNormal.java

Implementa uma função hash simples que calcula o índice com base no comprimento da string:

```java
public int hash(String value) {
    int length = value.length();
    return length % size;
}
```

- **Explicação**: A função utiliza o comprimento da string (`value.length()`) e calcula o índice com o operador módulo (`%`) em relação ao tamanho da tabela (`size`).
- **Vantagem**: É rápida e tem uma complexidade de `O(1)` para calcular o índice.
- **Desvantagem**: Pode gerar muitas colisões se muitas strings tiverem o mesmo comprimento.

### 4. FuncaoASCII.java

Esta classe implementa uma função hash que calcula o índice somando os valores das letras na string (considerando `a = 1`, `b = 2`, ..., `z = 26`).

```java
public int hash(String value) {
    int sum = 0;
    for (char c : value.toLowerCase().toCharArray()) {
        sum += c - 'a' + 1;
    }
    return sum % size;
}
```

- **Explicação**: A função percorre cada caractere da string, converte-o para um valor numérico e calcula a soma total. O índice final é o módulo dessa soma em relação ao tamanho da tabela (`size`).
- **Vantagem**: Pode distribuir as chaves de forma mais uniforme, especialmente se as strings forem variadas.
- **Desvantagem**: É mais lenta que `FuncaoNormal` para strings longas, pois precisa percorrer cada caractere, o que resulta em uma complexidade `O(n)`.

### 5. HashTablePerformance.java

A classe `HashTablePerformance` mede o desempenho das tabelas hash, especificamente:

- `tempoDeInsercao`: Mede o tempo necessário para inserir todos os elementos em uma tabela hash.
- `tempoDeBusca`: Mede o tempo necessário para realizar a busca de todos os elementos.
- **Getters**: Fornece acesso ao tempo de inserção, tempo de busca e tempo total.



## Como Compilar e Executar (vscode pelo menos)

- Compila e coloca as classes na pasta class

```bash
    javac -d class *.java
```

- Executa utilizando as classes da pasta class

```bash
    java -cp class Main  
```

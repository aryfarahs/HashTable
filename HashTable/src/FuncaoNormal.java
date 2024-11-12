public class FuncaoNormal extends HashTable {

    @Override
    public int hash(String value) {
        int length = value.length();
        int hash = length * 17;  // Multiplica o comprimento por um número primo

        // Combinando os valores dos caracteres da string com o comprimento
        for (int i = 0; i < value.length(); i++) {
            hash = (hash * 31) + value.charAt(i);  // Número primo 31 para dispersão
        }

        // Aplica o módulo para garantir que o valor de hash caiba dentro do tamanho da tabela
        return Math.abs(hash % size);
    }
}

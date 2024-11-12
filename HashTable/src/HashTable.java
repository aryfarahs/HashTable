import java.util.Arrays;

public abstract class HashTable {
    protected String[] table;
    protected int size;
    protected int elementCount;

    private static final int TAM_INICIAL = 50;
    private static final double FATOR_CARGA = 0.7;

    public HashTable() {
        this.size = TAM_INICIAL;
        this.table = new String[size];
        this.elementCount = 0;
    }

    public abstract int hash(String value);

    public void insert(String value) {
        if (fatorCarga() >= FATOR_CARGA) {
            resizeTable();
        }
        int index = Math.abs(hash(value) % size);

        // Loop para endereçamento linear até encontrar uma posição vazia
        while (table[index] != null) {
            index = (index + 1) % size;
        }
        table[index] = value;
        elementCount++;
    }

    private double fatorCarga() {
        return (double) elementCount / size;
    }

    private void resizeTable() {
        int newSize = size * 2;
        String[] oldTable = table;
        table = new String[newSize];
        size = newSize;
        elementCount = 0;

        for (String value : oldTable) {
            if (value != null) {
                insert(value);  // re-insere os valores na tabela redimensionada
            }
        }
    }

    public boolean search(String value) {
        int index = Math.abs(hash(value) % size);
        int indexInicial = index;

        while (table[index] != null) {
            if (table[index].equals(value)) {
                return true;
            }
            index = (index + 1) % size;
            if (index == indexInicial) {
                break;
            }
        }
        return false;
    }

    public int countColisoes() {
        int totalCollisions = 0;
        for (int i = 0; i < size; i++) {
            totalCollisions += countColisoesPosicao(i);
        }
        return totalCollisions;
    }

    public void printColisoes() {
        System.out.println("Distribuição da Tabela Hash (apenas posições com colisões):");
        for (int i = 0; i < size; i++) {
            int colisoesNaPosicao = countColisoesPosicao(i);
            if (colisoesNaPosicao > 0) {
                System.out.println("Posição " + i + ": " + colisoesNaPosicao + " colisões");
            }
        }
    }

    private int countColisoesPosicao(int position) {
        if (table[position] == null) {
            return 0;
        }
        int originalIndex = Math.abs(hash(table[position]) % size);
        if (originalIndex == position) {
            return 0; 
        }
        int collisions = 0;
        int index = originalIndex;
        while (index != position) {
            if (table[index] != null) {
                collisions++;
            }
            index = (index + 1) % size;
        }
        return collisions;
    }
}

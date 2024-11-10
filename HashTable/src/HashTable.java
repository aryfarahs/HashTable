import java.util.Arrays;

public abstract class HashTable {
    protected String[] table;
    protected int size;
    protected int elementCount;  // Contador de elementos inseridos na tabela

    // Tamanho inicial e fator de carga para redimensionamento
    private static final int INITIAL_SIZE = 20;
    private static final double LOAD_FACTOR = 0.7;

    // Construtor
    public HashTable() {
        this.size = INITIAL_SIZE;
        this.table = new String[size];
        this.elementCount = 0;
    }

    // Método para inserção com redimensionamento quando a carga atinge 70%
    public void insert(String value) {
        if (loadFactor() >= LOAD_FACTOR) {
            resizeTable();
        }

        int index = hash(value);
        int originalIndex = index;

        // Endereçamento homogêneo linear para resolver colisões
        while (table[index] != null) {
            index = (originalIndex + 1) % size;
            if (index == originalIndex) {
                throw new IllegalStateException("Tabela hash cheia");
            }
        }

        table[index] = value;
        elementCount++;
    }

    // Função de carga para determinar quando redimensionar
    private double loadFactor() {
        return (double) elementCount / size;
    }

    // Método para redimensionar e re-hashear os elementos
    private void resizeTable() {
        int newSize = size * 2;
        String[] oldTable = table;
        table = new String[newSize];
        size = newSize;
        elementCount = 0;

        for (String value : oldTable) {
            if (value != null) {
                insert(value);  // Re-insere os valores na nova tabela
            }
        }
    }

    // Função de hash abstrata para ser implementada pelas subclasses
    public abstract int hash(String value);

    // Método de busca
    public boolean search(String value) {
        int index = hash(value);
        int originalIndex = index;

        while (table[index] != null) {
            if (table[index].equals(value)) {
                return true;
            }
            index = (originalIndex + 1) % size;
            if (index == originalIndex) {
                break;
            }
        }

        return false;
    }

    // Contador de colisões para análise
    public int countCollisions() {
        int collisions = 0;
        for (String value : table) {
            if (value != null && Arrays.stream(table).filter(val -> val != null && val.equals(value)).count() > 1) {
                collisions++;
            }
        }
        return collisions;
    }

    // Exibição da distribuição da tabela
    public void displayDistribution() {
        for (int i = 0; i < size; i++) {
            System.out.println("Posição " + i + ": " + (table[i] != null ? table[i] : "vazio"));
        }
    }
}

import java.util.Arrays;

public abstract class HashTable {
    protected String[] table;
    protected int size;
    protected int elementCount;  

    private static final int INITIAL_SIZE = 20;
    private static final double LOAD_FACTOR = 0.7;

    public HashTable() {
        this.size = INITIAL_SIZE;
        this.table = new String[size];
        this.elementCount = 0;
    }

    public void insert(String value) {
        if (loadFactor() >= LOAD_FACTOR) {
            resizeTable();
        }
    
        int index = Math.abs(hash(value) % size);  // garante que o índice seja positivo e dentro dos limites
        int originalIndex = index;
    
        // Endereçamento linear
        while (table[index] != null) {
            index = (index + 1) % size;
            if (index == originalIndex) {
                throw new IllegalStateException("Tabela hash cheia");
            }
        }
    
        table[index] = value;
        elementCount++;
    }
    
    private double loadFactor() {
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
                insert(value);  // Re-insere os valores na nova tabela
            }
        }
    }

    public abstract int hash(String value);

    public boolean search(String value) {
        int index = Math.abs(hash(value) % size);  
        int originalIndex = index;
    
        while (table[index] != null) {
            if (table[index].equals(value)) {
                return true;
            }
            index = (index + 1) % size;
            if (index == originalIndex) {
                break;
            }
        }
    
        return false;
    }
    
    public int countCollisions() {
        int collisions = 0;
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (table[i] != null && !visited[i]) {
                int index = hash(table[i]);
                if (index != i) {
                    collisions++;
                }
                visited[i] = true;
            }
        }
        return collisions;
    }

    public void displayDistribution() {
        for (int i = 0; i < size; i++) {
            System.out.println("Posição " + i + ": " + (table[i] != null ? table[i] : "vazio"));
        }
    }
}

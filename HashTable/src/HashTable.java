import java.util.Arrays;

public abstract class HashTable {
    protected String[] table;
    protected int size;
    protected int elementCount;
    protected int peso = 2;  

    private static final int INITIAL_SIZE = 10;
    private static final double LOAD_FACTOR = 0.7;
    private int collisionCount;

    public HashTable() {
        this.size = INITIAL_SIZE;
        this.table = new String[size];
        this.elementCount = 0;
        this.collisionCount = 0; 
    }

    public void insert(String value, int peso) {
        if (loadFactor() >= LOAD_FACTOR) {
            resizeTable();
        }
    
        int index = Math.abs(hash(value, peso) % size);  
        int originalIndex = index;

        if (table[index] != null) {
            collisionCount++;
        }

        while (table[index] != null) {
            index = (index + 1) % size;
            if (index == originalIndex) {
                throw new IllegalStateException("Tabela hash cheia");
            }
        }
    
        table[index] = value;
        elementCount++;
        System.out.println(hash(value, peso));
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
        collisionCount = 0; 

        for (String value : oldTable) {
            if (value != null) {
                insert(value);  
            }
        }
    }

    public abstract int hash(String value, int peso);

    public boolean search(String value) {
        int index = Math.abs(hash(value, int peso) % size);  
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
        return collisionCount;
    }

    public void displayDistribution() {
        for (int i = 0; i < size; i++) {
            System.out.println("Posição " + i + ": " + (table[i] != null ? table[i] : "vazio"));
        }
    }
}

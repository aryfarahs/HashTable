import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class HashTable {
    protected String[] table;
    protected int size;
    protected int elementCount;  

    private static final int TAM_INICIAL = 500;
    private static final double FATOR_CARGA = 0.9;

    public HashTable() {
        this.size = TAM_INICIAL;
        this.table = new String[size];
        this.elementCount = 0;
    }
    
    public abstract int hash(String value);

    public void insert(String value) {
        if (fatorcarga() >= FATOR_CARGA) {
            resizeTable();
        }
        int index = Math.abs(hash(value) % size);
        int indexInicial = index;
    
        while (table[index] != null) {
            index = (index + 1) % size;
        }
        table[index] = value;
        elementCount++;
    }
    
    private double fatorcarga() {
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
                insert(value);  //re-insere
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

    public void printColisoes() {
        System.out.println("Distribuição da Tabela Hash (apenas posições com colisões):");
        for (int i = 0; i < size; i++) {
            int collisions = countColisoePosicao(i);
            if (collisions > 0) {
                System.out.println("Posição " + i + ": " + collisions + " colisões");
            }
        }
    }
    
    private int countColisoePosicao(int position) {
        int collisions = 0;
        int index = position;
        while (table[index] != null) {
            collisions++;
            index = (index + 1) % size;
            if (index == position) {
                break;
            }
        }
        return collisions - 1;
    }    
}

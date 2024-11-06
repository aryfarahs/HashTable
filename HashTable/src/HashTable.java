import java.util.ArrayList;
import java.util.List;

public abstract class HashTable {
    protected List<Node<String>>[] table;
    protected int size;

    public HashTable() {
        this.size = 50; 
        this.table = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new ArrayList<>();
        }
    }

    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new ArrayList<>();
        }
    }

    public abstract int funcaoHash(String value);
    public abstract void insert(String value);
    public abstract boolean search(String value);

    public int countCollisions() {
        int collisions = 0;
        for (List<Node<String>> bucket : table) {
            if (bucket.size() > 1) {
                collisions += bucket.size() - 1;
            }
        }
        return collisions;
    }

    public void displayDistribution() {
        for (int i = 0; i < size; i++) {
            System.out.println("Bucket " + i + ": " + table[i].size() + " elementos");
        }
    }
}

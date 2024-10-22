public abstract class HashTable<K, V> {
    private String[] table;
    private int size = 50;

    // CONSTRUCTOR
    public HashTable() {
        this.table = new String[size];
    }

    // GETTERS & SETTERS
    public String[] getTable() {
        return table;
    }
    public int getSize() {
        return size;
    }

    public void setTable(String[] table) {
        this.table = table;
    }
    public void setSize(int size) {
        this.size = size;
    }


    // ABSTRACT METHODS
    public abstract int funcaoHash(K key);


}

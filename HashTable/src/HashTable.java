public abstract class HashTable {
    protected String[] table;
    protected int size = 50;

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

   // METHODS


    // ABSTRACT METHODS
    public abstract int funcaoHash(int key);
    public abstract void insert(String value);

}

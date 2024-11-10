public class HashTableSoma extends HashTable {

    public HashTableSoma(int size) {
        super(size);
    }

    @Override
    public int funcaoHash(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        return hash % size;
    }
}

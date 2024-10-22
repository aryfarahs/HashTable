public class HashTableNode extends HashTable {

    @Override
    public void insert(String value) {
        int key = funcaoHash(value.length());

        if (table[key] == null) {
            table[key] = value;
        } else {
            int i = 1;
            while (table[key] != null) {
                key = funcaoHash(value.length() + i);
                i++;
            }
            table[key] = value;
        }
    }

    @Override
    public int funcaoHash(int key) {
        return key % size;
    }

}

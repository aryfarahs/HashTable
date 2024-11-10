public class HashTableTamanho extends HashTable {

    public HashTableTamanho(int size) {
        super(size);
    }
    
    @Override
    public int funcaoHash(String key) {
        int keySize = key.length();
        return keySize % size;
    }

}

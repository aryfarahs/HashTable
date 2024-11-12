public class FuncaoNormal extends HashTable {

    @Override
    public int hash(String value) {
        int length = value.length();
        int hash = length * 17; 
        for (int i = 0; i < value.length(); i++) {
            hash = (hash * 31) + value.charAt(i);  
        }
        return Math.abs(hash % size);
    }
}

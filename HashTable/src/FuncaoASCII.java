public class FuncaoASCII extends HashTable {

    @Override
    public int hash(String value) {
        int sum = 0;
        for (char c : value.toLowerCase().toCharArray()) {
            sum += c - 'a' + 1;  
        }
        return sum % size;
    }
}

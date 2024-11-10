public class FuncaoASCII extends HashTable {

    @Override
    public int hash(String value) {
        int sum = 0;
        for (char c : value.toLowerCase().toCharArray()) {
            sum += c - 'a' + 1;  // Converte 'a' a 'z' para valores de 1 a 26
        }
        return sum % size;
    }
}
public class FuncaoASCII extends HashTable {

    @Override
    public int hash(String value) {
        int sum = 0;
        for (char c : value.toLowerCase().toCharArray()) {
            sum += c - 'a' + 1;  // Converte 'a' a 'z' para valores de 1 a 26
        }
        return sum % size;
    }
}

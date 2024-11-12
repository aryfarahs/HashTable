public class Funcao1Soma extends HashTable {

    @Override
    public int hash(String value) {
        long sum = 0;
        
        for (char c : value.toLowerCase().toCharArray()) {
            sum = sum * 31 + c;  
        }
        sum += value.length() * 31;
        
        return (int)(sum % size);  
    }
}

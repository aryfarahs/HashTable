public class FuncaoNormal extends HashTable {

    @Override
    public int hash(String value) {
        int length = value.length();
        int aux = length * 31;
        return aux % size;
    }
}

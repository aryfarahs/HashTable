public class FuncaoNormal extends HashTable {

    @Override
    public int hash(String value) {
        int length = value.length();
        return length % size;
    }
}

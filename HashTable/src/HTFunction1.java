public class HTFunction1 extends HashTable {

    public HTFunction1() {
        super(); 
    }

    @Override
    public int funcaoHash(String value) {
        double A = 0.6180339887;  
        int hash = 0;
        for (char c : value.toCharArray()) {
            hash += c * A; 
        }
        return (int) (Math.abs(hash) % size);  
    }

    @Override
    public void insert(String value) {
        int index = funcaoHash(value);
        table[index].add(new Node<>(value));
    }

    @Override
    public boolean search(String value) {
        int index = funcaoHash(value);
        for (Node<String> node : table[index]) {
            if (node.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}

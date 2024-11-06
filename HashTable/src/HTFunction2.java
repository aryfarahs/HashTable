public class HTFunction2 extends HashTable {

    public HTFunction2() {
        super();
    }

    @Override
    public int funcaoHash(String value) {
        int hash = 0;
        for (char c : value.toCharArray()) {
            hash = c + (hash << 6) + (hash << 16) - hash;  // Operações de deslocamento e soma
        }
        return Math.abs(hash) % size;  
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

public abstract class HashTable {
    protected Node<String>[] table;
    protected int size;
    protected int colisions = 0;

    public HashTable(int size) {
        this.size = size;
        this.table = new Node[size];
    }

    protected abstract int funcaoHash(String key);

    public int insert(String value) {
        int key = funcaoHash(value);

        if (table[key] == null) {
            table[key] =  new Node<>(value);

        } else {
            colisions++;

            Node<String> current = table[key];
            while (current.getNext() != null) {
                current = current.getNext();
            }
            Node<String> newNode = new Node<>(value);
            current.setNext(newNode);
            current.setPrev(current);
        }

        return colisions;
    }

    public boolean search(String value) {
        int key = funcaoHash(value);
        Node<String> current = table[key];

        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void remove(String value) {
        int key = funcaoHash(value);
        Node<String> current = table[key];

        while (current != null) {
            if (current.getValue().equals(value)) {
                if (current.getPrev() == null) {
                    table[key] = current.getNext();
                } else {
                    current.getPrev().setNext(current.getNext());
                }
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                }
                return;
            }
            current = current.getNext();
        }

    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            Node<String> current = table[i];
            System.out.print(i + ": ");
            while (current != null) {
                System.out.print(current.getValue() + " | ");
                current = current.getNext();
            }
            System.out.println();
        }
    }
}

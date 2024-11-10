public class Node<T> {
    protected T value;
    protected Node<T> prev, next;

    public Node(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }


    public T getValue() {
        return this.value;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
}

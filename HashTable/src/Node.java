public class Node<T> {
    protected T value;
    protected Node<T> left, right;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }


    public T getValue() {
        return this.value;
    }

    public Node<T> getRight() {
        return right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setValue(T value) {
        this.value = this.value;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }
}

package codingninja.bst;

public class NodeObj<T> {
    T data;
    NodeObj next;

    public NodeObj(T data) {
        this.data = data;
        this.next = null;
    }
}

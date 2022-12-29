package codingninja.bst;

public class StackUsingLL<T> {
    private NodeObj<T> head;
    private NodeObj<T> tail;
    private int size = 0;

    public StackUsingLL() {
    }

    public void push(T value) {
        NodeObj<T> nodeObj = new NodeObj<>(value);
        if (head == null)
            head = nodeObj;
        else
            nodeObj.next = head;
        head = nodeObj;
        size++;
        print(head);
    }

    public T top() {
        return head.data;
    }

    public int size() {
        return size;
    }
    public T pop() {
        size--;
        T data =  head.data;
        head = head.next;
        print(head);
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    void print(NodeObj<T> head){
        if(head == null) {
            System.out.println();
            return;
        };
        System.out.print(head.data +" ");
        print(head.next);
    }
}

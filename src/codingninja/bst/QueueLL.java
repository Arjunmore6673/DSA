package codingninja.bst;

public class QueueLL<T> {
    private NodeObj<T> front;
    private NodeObj<T> rear;
    private int size = 0;

    public int size() {
        return size;
    }

    public T getFront() {
        if (front == null) {
            System.out.println("queue empty");
            return null;
        }
        return front.data;
    }

    public void enqueue(T data) {
        NodeObj<T> node = new NodeObj<>(data);
        if (size == 0)
            front = node;
        if (rear == null)
            rear = node;
        else {
            rear.next = node;
            rear = node;
        }

        print();
        size++;
    }

    private void print() {
        NodeObj<T> temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public T dequeue() {
        print();
        if (front == null) {
            System.out.println("empty already");
            return null;
        }
        T data = front.data;
        front = front.next;
        size--;

        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

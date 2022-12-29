package codingninja.bst;

import java.util.Arrays;

public class QueueArr {
    private int[] data;
    private int front = -1;
    private int rear = -1;
    private int size = 0;

    QueueArr() {
        data = new int[3];
    }

    QueueArr(int size) {
        data = new int[size];
    }

    public void enqueue(int d) {
        if (size == data.length)
            return;
//        for first time
        if (size == 0)
            front = 0;

        rear++;
        if (rear == data.length)
            rear = 0;

        data[rear] = d;
        size++;
        print();
    }

    void print() {
        System.out.println(Arrays.toString(data));
    }

    public int dequeue() {
        if (size == 0)
            return -1;
        int d = data[front];
        data[front] = -1;
        size--;
        front++;
        if (front == data.length)
            front = 0;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        print();
        return d;
    }

    public int size(int data) {
        return size;
    }

    public boolean isEmpty(int data) {
        return size == 0;
    }

    public int front() {
        if (front == -1) return -1;
        if (front > data.length) return -1;
        return data[front];
    }

}

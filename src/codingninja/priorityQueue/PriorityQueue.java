package codingninja.priorityQueue;

import java.util.ArrayList;

public class PriorityQueue<T> {
    ArrayList<Element<T>> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority) {
//        need to insert at last.
        Element<T> element = new Element<>(value, priority);
        heap.add(element);

//        check parent element is smaller or not.
        int childIndex = size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex).priority < heap.get(parentIndex).priority) {
                Element<T> temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    public T getMin() throws PriorityQueueException {
        if (isEmpty()) throw new PriorityQueueException();
        return heap.get(0).value;
    }

    public T removeMin() throws PriorityQueueException {
        if (isEmpty()) throw new PriorityQueueException();
//      keep first element and swap last with first element.
        Element<T> elementRemoved = heap.get(0);
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
//      i need to check element is at right pos if not then swap
        int parentIndex = 0;
        int childIndexLeft = 2 * parentIndex + 1;
        int childIndexRight = 2 * parentIndex + 2;
        while (childIndexLeft < size()) {
            int minIndex = parentIndex;
            if (heap.get(childIndexLeft).priority < heap.get(parentIndex).priority)
                minIndex = childIndexLeft;

            if (childIndexRight < size() && heap.get(childIndexRight).priority < heap.get(minIndex).priority)
                minIndex = childIndexRight;

            if (minIndex == parentIndex)
                break;
//        swap with minIndex;
            Element<T> minElement = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, minElement);
            parentIndex = minIndex;
            childIndexLeft = 2 * parentIndex + 1;
            childIndexRight = 2 * parentIndex + 2;
        }
        return elementRemoved.value;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }
}

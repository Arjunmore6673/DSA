package codingninja.priorityQueue;

import java.util.ArrayList;

public class PQMax {

    private ArrayList<Integer> heap;

    public PQMax() {
        heap = new ArrayList<Integer>();
    }

    public static void main(String[] args) throws PriorityQueueException {
        PQMax pqMax = new PQMax();
        pqMax.insert(2);
        pqMax.insert(22);
        pqMax.insert(22);
        pqMax.insert(444);
        pqMax.insert(55);
        System.out.println(pqMax.heap);
        System.out.println(pqMax.getMax());
        pqMax.removeMin();
        System.out.println(pqMax.removeMin());
        System.out.println(pqMax.getMax());
        System.out.println(pqMax.removeMin());
    }

    boolean isEmpty() {
        return heap.size() == 0;
    }

    int size() {
        return heap.size();
    }

    int getMax() throws PriorityQueueException {
        if (isEmpty()) {
            // Throw an exception
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex) > heap.get(parentIndex)) {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }
    }

    int removeMin() throws PriorityQueueException {
        if (isEmpty()) throw new PriorityQueueException();
        Integer removed = heap.get(0);
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);

        int parentIndex = 0;
        int leftIndex = (2 * parentIndex) + 1;
        int rightIndex = (2 * parentIndex) + 2;
        int mindex = parentIndex;
        while (leftIndex < size()) {
            if (heap.get(leftIndex) > heap.get(parentIndex)) {
                mindex = leftIndex;
            }
            if (rightIndex < size() && heap.get(rightIndex) > heap.get(parentIndex))
                mindex = rightIndex;

            if (mindex == parentIndex)
                break;

            Integer minIndexVal = heap.get(mindex);
            heap.set(mindex, heap.get(parentIndex));
            heap.set(parentIndex, minIndexVal);

            parentIndex = mindex;
            leftIndex = (2 * parentIndex) + 1;
            rightIndex = (2 * parentIndex) + 2;
        }
        return removed;
    }
}


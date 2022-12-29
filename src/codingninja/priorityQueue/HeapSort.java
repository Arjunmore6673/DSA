package codingninja.priorityQueue;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 34, 11, 21};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            downHeapify(arr, i, n);
        }
        // remove elements one by one and put them in at respective last pos.
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            downHeapify(arr, 0, i);
        }
    }

    private static void downHeapify(int[] arr, int i, int n) {
        int parentIndex = i;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        while (leftIndex < n) {
            int minIndex = parentIndex;
            if (arr[leftIndex] < arr[minIndex])
                minIndex = leftIndex;

            if (rightIndex < n && arr[rightIndex] < arr[minIndex])
                minIndex = rightIndex;

            if (minIndex == parentIndex)
                return;

            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;

            parentIndex = minIndex;
            leftIndex = 2 * parentIndex + 1;
            rightIndex = 2 * parentIndex + 2;
        }
    }
}

package codingninja.priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 34, 31, 21};
        ArrayList<Integer> output = kLargest(arr, 3);
        System.out.println(output);
        output = kSmallest(arr, 3);
        System.out.println(output);
        int out = kthLargest(arr.length, arr, 3);
        System.out.println(out);
    }

    public static ArrayList<Integer> kLargest(int arr[], int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            priorityQueue.add(arr[i]);

        for (int i = k; i < arr.length; i++) {
            if (!priorityQueue.isEmpty() && priorityQueue.peek() < arr[i]) {
                priorityQueue.add(arr[i]);
                priorityQueue.poll();
            }
        }
        return new ArrayList<>(priorityQueue);
    }

    public static ArrayList<Integer> kSmallest(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (!priorityQueue.isEmpty() && priorityQueue.peek() > arr[i]) {
                priorityQueue.add(arr[i]);
                priorityQueue.poll();
            }
        }
        return new ArrayList<>(priorityQueue);
    }

    public static int kthLargest(int n, int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            priorityQueue.add(arr[i]);
        for (int i = k; i < arr.length; i++) {
            if (!priorityQueue.isEmpty() && priorityQueue.peek() < arr[i]) {
                priorityQueue.add(arr[i]);
                priorityQueue.poll();
            }
        }
        return !priorityQueue.isEmpty() ? priorityQueue.peek() : -1;
    }
}

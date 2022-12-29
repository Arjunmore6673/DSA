package codingninja.priorityQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTicket {
    public static void main(String[] args) {
        int[] arr = {3, 9, 4};
        int out = buyTicket(arr, 0);
        out = buyTicket(new int[]{2, 3, 2, 2, 4}, 3);
        System.out.println(out);
    }

    public static int buyTicket(int input[], int k) {
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : input) {
            q.add(i);
            pq.add(i);
        }
        int count = 0;
        while (!pq.isEmpty()) {
            if (q.peek().equals(pq.peek())) {
                if (k == 0) {
                    return count + 1;
                } else {
                    count++;
                    q.poll();
                    pq.poll();
                    k--;
                }
            } else {
                q.add(q.poll());
                if (k == 0) {
                    k = q.size() - 1;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}

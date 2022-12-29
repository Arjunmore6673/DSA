package codingninja.dynamicprogramming;

import java.util.Arrays;

public class MinSquareToGetNumber {

    public static void main(String[] args) {
        int number = 22;
        //  System.out.println(minSquare(number));
        int[] arr = new int[number + 1];
        Arrays.fill(arr, -1);
        System.out.println(minSquareDP(number, arr));
        System.out.println(minSquareItrative(number));
    }

    private static int minSquareItrative(int n) {
        if (n == 0) return 0;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minAns = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int currentAns = arr[i - (j * j)];
                minAns = Math.min(currentAns, minAns);
            }
            arr[i] = minAns + 1;
        }
        return arr[n];
    }

    private static int minSquareDP(int n, int[] arr) {
        if (n == 0) return 0;
        arr[0] = 0;
        if (arr[n] != -1)
            return arr[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int current = minSquareDP(n - (i * i), arr);
            min = Math.min(current, min);
        }
        arr[n] = min + 1;
        return arr[n];
    }

    private static int minSquare(int n) {
        if (n == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int current = minSquare(n - (i * i));
            min = Math.min(current, min);
        }
        return min + 1;
    }
}


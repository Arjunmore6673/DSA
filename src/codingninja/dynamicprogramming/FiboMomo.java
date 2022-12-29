package codingninja.dynamicprogramming;

import java.util.Arrays;

public class FiboMomo {
    public static void main(String[] args) {
        int number = 6;
        int[] arr = new int[number + 1];
//        initializing array with -1 values
        Arrays.fill(arr, -1);
//        System.out.println(calculateFiboDP(number, arr));
        System.out.println(calculateFibDPIterative(number));
    }

    private static int calculateFibDPIterative(int number) {
        int[] arr = new int[number + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2;i<=number;i++){
            arr[i]= arr[i-1] + arr[i-2];
        }
        return arr[number];
    }

    private static int calculateFiboDP(int n, int[] arr) {
        if (n == 0) return n;
        if (n == 1) return n;
        int ans1;
        int ans2;
        if (arr[n - 1] == -1) {
            ans1 = calculateFiboDP(n - 1, arr);
            arr[n - 1] = ans1;
        } else
            ans1 = arr[n - 1];


        if (arr[n - 2] == -1) {
            ans2 = calculateFiboDP(n - 2, arr);
            arr[n - 2] = ans2;
        } else {
            ans2 = arr[n - 2];
        }
        return ans1 + ans2;
    }

    private static int calculateFibo(int i) {
        if (i == 0) return i;
        if (i == 1) return i;
        int ans1 = calculateFibo(i - 1);
        int ans2 = calculateFibo(i - 2);
        return ans1 + ans2;
    }


}

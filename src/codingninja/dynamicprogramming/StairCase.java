package codingninja.dynamicprogramming;

public class StairCase {


    public static void main(String[] args) {
        int number = 4;
        int[] arr = new int[number + 1];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= number; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        System.out.println(arr[number]);

    }
}

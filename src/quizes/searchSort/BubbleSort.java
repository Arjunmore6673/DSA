package quizes.searchSort;

/*
Provided with a random integer array/list(ARR) of size N,
you have been required to sort this array using 'Bubble Sort'.

Sample Input 1:

1
7
2 13 4 1 3 6 28

Sample Output 1:
1 2 3 4 6 13 28

*/
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

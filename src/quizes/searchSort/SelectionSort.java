package quizes.searchSort;

/*
 Selection Sort
Send Feedback
Provided with a random integer array/list(ARR) of size N,
you have been required to sort this array using 'Selection Sort'.

Sample Input 1:

1
7
2 13 4 1 3 6 28

Sample Output 1:
1 2 3 4 6 13 28

*
*/
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}

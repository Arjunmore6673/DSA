package quizes.searchSort;

/*
You have been given two sorted arrays/lists(ARR1 and ARR2) of size N and M respectively,
merge them into a third array/list such that the third array is also sorted.

Sample Input 1 :
1
5
1 3 4 7 11
4
2 4 6 13

Sample Output 1 :
1 2 3 4 4 6 7 11 13

*/
public class MergeSort {

    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0;
        int j = 0;
        int k = 0;

        int[] output = new int[m + n];
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                output[k] = arr1[i];
                i++;
            } else {
                output[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            output[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n) {
            output[k] = arr2[j];
            j++;
            k++;
        }
        return output;
    }
}

package quizes.searchSort.problems;

import java.util.Arrays;

/*
You have been given a random integer array/list(ARR) of size N. You have been required to push all the zeros that are present in the array/list to the end of it.
 Also, make sure to maintain the relative order of the non-zero elements.
Sample Input 1:
1
7
2 0 0 1 3 0 0

Sample Output 1:
2 1 3 0 0 0 0

*/
public class PushZerosEnd {

    public static void pushZerosAtEnd(int[] arr) {
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
        }
        while (j < n) {
            arr[j] = 0;
            j++;
        }
        System.out.print(Arrays.toString(arr));
    }

}

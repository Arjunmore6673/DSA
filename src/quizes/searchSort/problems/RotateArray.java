package quizes.searchSort.problems;

/* Rotate array
You have been given a random integer array/list(ARR) of size N.
Write a function that rotates the given array/list by D elements(towards the left).
Sample Input 1:
1
7
1 2 3 4 5 6 7
2

Sample Output 1:
3 4 5 6 7 1 2
*/


public class RotateArray {
    public static void rotate(int[] arr, int d) {
        int n = arr.length;
        int[] temp = new int[d];
        for(int i=0;i<d; i++)
            temp[i]=arr[i];
        int i=0;
        for(int j= d; j<n; j++){
            arr[i]=arr[j];
            i++;
        }
        int tIndex=0;
        for(int j=i; j<n; j++)
            arr[j]= temp[tIndex++];
    }
}

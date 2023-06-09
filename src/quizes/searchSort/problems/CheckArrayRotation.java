package quizes.searchSort.problems;
/*
You have been given an integer array/list(ARR) of size N.
It has been sorted(in increasing order) and then rotated by some number 'K' (K is greater than 0)
in the right hand direction.
Your task is to write a function that returns the value of 'K',
that means, the index from which the array/list has been rotated.

Sample Input 1:
1
6
5 6 1 2 3 4

Sample Output 1:
2

*/
public class CheckArrayRotation {
    public static int arrayRotateCheck(int[] arr){
        int min = Integer.MAX_VALUE;
        int index= 0;
        int n =arr.length;
        for(int i=0; i<n;i++){
            if(arr[i] < min){
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}

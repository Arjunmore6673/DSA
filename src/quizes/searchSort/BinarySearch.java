package quizes.searchSort;
/*
You have been given a sorted(in ascending order) integer array/list(ARR) of size N and an element X.
Write a function to search this element in the given input array/list using 'Binary Search'.
Return the index of the element in the input array/list. If the element is not present in the array/list,
then return -1.

Sample Input 1:

7
1 3 7 9 11 12 45
3

Sample Output 1:
1

*/
public class BinarySearch {

    public static int binarySearch(int[] arr, int x) {
        int start= 0;
        int end = arr.length - 1;
        while(start<=end){
            int mid = (start + end) / 2;
            if(arr[mid] == x)
                return mid;
            if(x>arr[mid])
                start = mid+1;
            if(x<arr[mid])
                end = mid-1;
        }
        return -1;
    }
}

package quizes.searchSort.problems;
/*
You have been given a random integer array/list(ARR) of size N. You are required to
find and return the second largest element present in the array/list.
If N <= 1 or all the elements are same in the array/list then
return -2147483648 or -2 ^ 31(It is the smallest value for the range of Integer)
Sample Input 1:
1
7
2 13 4 1 3 6 28

Sample Output 1:
13


*/
public class SecondLargest {

    public static int secondLargestElement(int[] arr) {
        int n = arr.length;
        int firstLarge = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            firstLarge =Math.max(firstLarge,arr[i]);

        for(int i=0;i<n;i++)
            if(arr[i] != firstLarge)
                secondLarge =Math.max(secondLarge,arr[i]);

        return secondLarge;

    }
}

package quizes.searchSort.problems;

/*
Two random integer arrays/lists have been given as ARR1 and ARR2 of size N and M respectively.
Both the arrays/lists contain numbers from 0 to 9(i.e. single digit integer is present at every index)
The idea here is to represent each array/list as an integer in itself of digits N and M.
You need to find the sum of both the input arrays/list treating them as two integers and
put the result in another array/list i.e. output array/list will also contain only single digit at every index.

Sample Input 1:
1
3
6 2 4
3
7 5 6

Sample Output 1:
1 3 8 0

*/
public class SumTwoArrays {


    public static int[] moveZeroFront(int[] arr, int n) {
        int[] newArr = new int[n];
        int index = n - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                newArr[index] = arr[i];
                index--;
            }
        }
        return newArr;

    }

    public static void sumOfTwoArrays(int[] arr1, int[] arr2, int[] output) {
        int carry = 0;
        int n = arr1.length;
        int m = arr2.length;
        int index = output.length - 1;
        arr2 = moveZeroFront(arr2, n > m ? n : m);

        int i = arr1.length - 1, j = arr2.length - 1;
        while (i >= 0 && j >= 0) {
            int result = arr1[i] + arr2[j] + carry;
            carry = 0;
            int last = result % 10;
            carry = result / 10;
            output[index] = last;
            i--;
            j--;
            index--;
        }
        if (carry > 0)
            output[index] = carry;


    }
}

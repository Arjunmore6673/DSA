package quizes.array;

/*
For a given two-dimensional integer array/list of size (N x M),
print the array/list in a sine wave order, i.e, print the first column top
to bottom, next column bottom to top and so on.
Input format :

The first line contains an Integer 't' which denotes the number of test
cases or queries to be run. Then the test cases follow.

First line of each test case or query contains two integer values, 'N' and 'M',
separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

Second line onwards, the next 'N' lines or rows represent the ith row values.
Each of the ith row constitutes 'M' column values separated by a single space.

Sample Input 2:

2
5 3
1 2 3
4 5 6
7 8 9
10 11 12
13 14 15
3 3
10 20 30
40 50 60
70 80 90

Sample Output 2:

1 4 7 10 13 14 11 8 5 2 3 6 9 12 15
10 40 70 80 50 20 30 60 90

*/
public class PrintLikeWave {

    public static void wavePrint(int[][] mat) {
        int rows = mat.length;
        if (rows == 0) return;
        int cols = mat[0].length;
        boolean chk = true;
        for (int i = 0; i < cols; i++) {
            if (chk) {
                for (int j = 0; j < rows; j++)
                    System.out.print(mat[j][i] + " ");
                chk = false;
            } else {
                for (int j = rows - 1; j >= 0; j--)
                    System.out.print(mat[j][i] + " ");
                chk = true;
            }
        }
    }

}
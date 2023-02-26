package quizes.array;
/*
For a given two-dimensional integer array/list of size (N x M),
print it in a spiral form. That is, you need to print in the order followed for every iteration:

a. First row(left to right)
b. Last column(top to bottom)
c. Last row(right to left)
d. First column(bottom to top)

Sample Input 1:

1
4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

Sample Output 1:

1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

 */


public class PrintSpiral {

    public static void spiralPrint(int matrix[][]) {
        if (matrix.length == 0) return;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int direction = 0;
        if (right == 0 || bottom == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[j][i] + " ");
                }
            }
            return;
        }
        while (true) {
            if (left > right) {
                break;
            }
            /// print first row.
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.print(matrix[top][i] + " ");
                }
                top += 1;
                direction = 1;
            }
            /// print right column
            if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    System.out.print(matrix[i][right] + " ");
                }
                right -= 1;
                direction = 2;
            }
            if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                direction = 3;
                bottom -= 1;
            }

            if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
                direction = 0;
            }


        }
    }
}
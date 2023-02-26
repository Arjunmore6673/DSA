package quizes.array;

/*
*  Row Wise Sum
Send Feedback
For a given two-dimensional integer array/list of size (N x M),
* find and print the sum of each of the row elements in a single line, separated by a single space.
* */

public class RowSum {
    public static void rowWiseSum(int[][] mat) {
        int rows=mat.length;
        if(rows == 0) return;
        int cols=mat[0].length;

        for(int i=0;i<rows;i++){
            int sum = 0;
            for(int j=0;j<cols;j++){
                sum+=mat[i][j];
            }
            System.out.print(sum + " ");
        }
    }
}

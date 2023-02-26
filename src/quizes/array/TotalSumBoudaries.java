package quizes.array;
/*
*  Total Sum on the Boundaries and Diagonals
 *
*For a given two-dimensional square matrix of size (N x N).
*  Find the total sum of elements on both the diagonals and at all the four boundaries.
*
*
* 1
3
1 2 3
4 5 6
7 8 9
*
* The boundary elements are 1, 2, 3, 6, 9, 8, 7 and 4.

The first-diagonal elements are 1, 5 and 9.

The second-diagonal elements are 3, 5 and 7.

We just need to add all these numbers making sure that no number is added twice. For example, '1' is both a boundary element and a first-diagonal element similarly, '5' contributes to both the diagonals but they won't be added twice.

Hence, we add up, [1 + 2 + 3 + 6 + 9 + 8 + 7 + 4 + 5] to give 45 as the output
*
* */

public class TotalSumBoudaries {


    public static void totalSum(int[][] mat) {

//         for first and last row all numbers.
//         for other first and last index
        int sumBoundries = 0;
        int sumBoundriesIn = 0;
        int sumDigonalLeft = 0;
        int sumDigonalRight = 0;
        int rightIndex = mat.length - 1;

        for (int i = 0; i < mat.length; i++) {
            int first = 0;
            int last = mat[i].length - 1;
            for (int j = 0; j <= last; j++) {
                if (i == 0 || last == i)
                    sumBoundries += mat[i][j];
                else if (j == 0 || j == last)
                    sumBoundriesIn += mat[i][j];
                if (i != 0 && i != last && j == i) {
                    sumDigonalLeft += mat[i][j];
                }
            }
            for (int k = last; k > 0; k--) {
                if (i != 0 && i != last && rightIndex - i == k && i != k)
                    sumDigonalRight += mat[i][k];
            }
        }
        System.out.println(sumDigonalRight + sumDigonalLeft + sumBoundriesIn + sumBoundries);
    }

}

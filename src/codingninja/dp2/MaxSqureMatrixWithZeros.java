package codingninja.dp2;

public class MaxSqureMatrixWithZeros {


    public static int findMaxSquareWithAllZeros(int[][] input, int i, int j) {
        if (i >= input.length) return 0;
        if (input[i][j] == 1) return 0;


        return 0;
    }

    public static int findMaxSquareWithAllZeros(int[][] input) {
        return findMaxSquareWithAllZeros(input, 0, 0);
    }


    public static void main(String[] args) {
        int[][] cost = new int[][]{{1, 1, 1}, {0, 0, 0}, {0, 0, 1}, {0, 0, 1}};
        MinCostPath.print(cost);
        System.out.println(findMaxSquareWithAllZeros(cost));
    }
}

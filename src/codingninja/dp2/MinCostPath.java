package codingninja.dp2;
import java.util.ArrayList;


public class MinCostPath {
    public static void main(String[] args) {
        int[][] cost = new int[][]{{1, 1, 1}, {8, 13, 1}, {1, 2, 2}, {2, 3, 1}};
//        int[][] memo = new int[cost.length + 1][cost[0].length + 1];
//        fillWithNegativeInfinity(memo);
        print(cost);
//        int ans = minCost(cost, 0, 0);
//        int ans = minCost(cost, 0, 0, memo);
        int ans = minCostItrativeBottomUp(cost);
        System.out.println(ans);
    }


    private static int minCostItrativeBottomUp(int[][] cost) {
        int n = cost.length;
        int m = cost[0].length;
        int[][] memo = new int[n + 1][m + 1];
        fillWithNegativeInfinity(memo);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    memo[i][j] = cost[i][j];
                    list.add(0, memo[i][j]);
                    continue;
                }
                int ansRight = memo[i][j + 1];
                int ansBottom = memo[i + 1][j];
                int ansDigonal = memo[i + 1][j + 1];
                int ans = cost[i][j] + Math.min(ansRight, Math.min(ansBottom, ansDigonal));
                list.add(0, ans);
                memo[i][j] = ans;
            }
        }
        print(memo);
        System.out.println(list);
        return memo[0][0];
    }

    private static int minCost(int[][] cost, int i, int j, int[][] memo) {
        int n = cost.length;
        int m = cost[0].length;
//      when i reach to last element of matrix
        if (n - 1 == i && m - 1 == j)
            return cost[i][j];

//      base case;
        if (i >= n) return Integer.MAX_VALUE;
        if (j >= m) return Integer.MAX_VALUE;

        if (memo[i][j] != 0)
            return memo[i][j];


        int ans = minCost(cost, i + 1, j, memo);
        int ans2 = minCost(cost, i, j + 1, memo);
        int ans3 = minCost(cost, i + 1, j + 1, memo);
        int myans = cost[i][j] + Math.min(ans, Math.min(ans2, ans3));

        memo[i][j] = myans;

        return memo[i][j];
    }

    public static void print(int[][] cost) {
//        System.out.println(cost[0][1]);
        int n = cost.length;
        int m = cost[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String str = cost[i][j] + "     ";
                System.out.print(str.substring(0, 3) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void fillWithNegativeInfinity(int[][] arr) {
//        System.out.println(cost[0][1]);
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    private static int minCost(int[][] cost, int i, int j) {
        int n = cost.length;
        int m = cost[0].length;
//      when i reach to last element of matrix
        if (n - 1 == i && m - 1 == j)
            return cost[i][j];
//      base case;
        if (i >= n) return Integer.MAX_VALUE;
        if (j >= m) return Integer.MAX_VALUE;

        int ans = minCost(cost, i + 1, j);
        int ans2 = minCost(cost, i, j + 1);
        int ans3 = minCost(cost, i + 1, j + 1);
        return cost[i][j] + Math.min(ans, Math.min(ans2, ans3));
    }
}

package codingninja.dp2;

public class CoinNumberSum {

    public static int countWaysToMakeChange(int[] denominations, int value, int i, int[][] dp) {
        if (i == denominations.length) return 0;
        if (value == 0) return 1;
        if (value < 0) return 0;
        if (dp[i][value] != 0) return dp[i][value];
//        include it.
        int ans;
        ans = countWaysToMakeChange(denominations, value - denominations[i], i, dp);
//        exclude it.
        ans += countWaysToMakeChange(denominations, value, i + 1, dp);
        dp[i][value] = ans;
        return ans;
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3, 4};
        int value = 4;
        int dp[][] = new int[coins.length + 1][value + 1];
        System.out.println(countWaysToMakeChange(coins, value, 0, dp));
    }
}

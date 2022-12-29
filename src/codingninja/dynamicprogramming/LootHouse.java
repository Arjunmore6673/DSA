package codingninja.dynamicprogramming;

import java.util.Arrays;

public class LootHouse {
    public static void main(String[] args) {
        int hval[] = {5, 3, 4, 11, 2};
        int n = hval.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Maximum loot possible : "
                + maxLoot(hval, n - 1, dp));
    }

    private static int maxLoot(int[] arr, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return arr[0];
        if (dp[n] != -1) return dp[n];
//        either he robs it
        int one = arr[n] + maxLoot(arr, n - 2, dp);
        int two = maxLoot(arr, n - 1, dp);
        int ans = Math.max(one, two);
        dp[n] = ans;
        return dp[n];
    }
}


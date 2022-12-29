package codingninja.dp2;

public class Knapsack {
    public static void main(String[] args) {
//        int[] values = new int[]{200, 300, 100};
//        int[] weights = new int[]{20, 25, 30};
        int[] values = new int[]{200, 200, 50, 100};
        int[] weights = new int[]{10, 20, 40, 30};
        int output = knapsack(weights, values, 50, 0);
        int output2 = knapsackIterative(weights, values, 50);
        System.out.println(output);
        System.out.println(output2);
    }


    public static int knapsack(int[] weights, int[] values, int maxWeight, int i) {
        if (i >= weights.length) return 0;
        int ans;
        if (weights[i] <= maxWeight) {
            int ans1 = values[i] + knapsack(weights, values, maxWeight - weights[i], i + 1);
            int ans2 = knapsack(weights, values, maxWeight, i + 1);
            ans = Math.max(ans1, ans2);
        } else {
            ans = knapsack(weights, values, maxWeight, i + 1);
        }
        return ans;
    }

    public static int knapsackIterative(int[] weights, int[] values, int maxWeight) {
        int n = values.length;
        int[][] dp = new int[n + 1][maxWeight + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int w = 0; w <= maxWeight; w++) {
                int ans;
                if (weights[i] <= w) {
                    int ans1 = values[i] + dp[i + 1][w - weights[i]];
                    int ans2 = dp[i + 1][w];
                    ans = Math.max(ans1, ans2);
                } else {
                    ans = dp[i + 1][w];
                }
                dp[i][w] = ans;
            }
        }
        return dp[0][maxWeight];
    }
}

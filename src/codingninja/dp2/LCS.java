package codingninja.dp2;

public class LCS {
    public static void main(String[] args) {
        String one = "31313131311313111";
        String two = "ab333333313134114d";
        int[][] dp = createDpArray2d(one, two);
//        int output = findLCS(one, two, 0, 0, dp);
        int output = findLCSIterative(one, two, one.length(), two.length(), dp);
        System.out.println(output);
    }

    private static int findLCSIterative(String one, String two, int m, int n, int[][] dp) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int ans;
                if (one.charAt(i) == two.charAt(j)) {
                    ans = 1 + dp[i + 1][j + 1];
                } else {
                    int ans1 = dp[i + 1][j];
                    int ans2 = dp[i][j + 1];
                    ans = Math.max(ans1, ans2);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }


    private static int findLCS(String one, String two, int i, int j, int[][] dp) {
        if (i >= one.length()) return 0;
        if (j >= two.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (one.charAt(i) == two.charAt(j)) {
            int smallAns = findLCS(one, two, i + 1, j + 1, dp);
            return 1 + smallAns;
        } else {
            int ans1 = findLCS(one, two, i + 1, j, dp);
            int ans2 = findLCS(one, two, i, j + 1, dp);
            int myAns = Math.max(ans1, ans2);
            dp[i][j] = myAns;
            return myAns;
        }
    }


    public static void print(int[][] cost) {
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

    private static int[][] createDpArray2d(String one, String two) {
        int[][] dp = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++) dp[i][j] = 0;
        return dp;
    }

}

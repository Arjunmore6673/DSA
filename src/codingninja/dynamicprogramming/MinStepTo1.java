package codingninja.dynamicprogramming;

public class MinStepTo1 {

    public static void main(String[] args) {
        int n = 6;
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) memo[i] = -1;
//        System.out.println(countMinStepsToOneDPR2(n, memo));
        System.out.println(countMinStepsToOneI(n, memo));
//        System.out.println(Arrays.toString(memo));
    }

    private static int countMinStepsToOneI(int n, int[] memo) {
        if (n == 1) return 0;
        memo[0] = 0;
        memo[1] = 0;
        for (int i = 2; i <= n; i++) {
            int min = memo[i - 1];
            if (i % 2 == 0) {
                min = Math.min(min,memo[i/2]);
            }
            if (i % 3 == 0) {
                min = Math.min(min,memo[i/3]);
            }
            memo[i] = min + 1;
        }
        return memo[n];
    }

    public static int countMinStepsToOne(int n) {
        if (n == 1)
            return 0;
        int ans1 = countMinStepsToOne(n - 1);
        int ans2 = Integer.MAX_VALUE;
        if (n % 2 == 0)
            ans2 = countMinStepsToOne(n / 2);
        int ans3 = Integer.MAX_VALUE;
        if (n % 3 == 0)
            ans3 = countMinStepsToOne(n / 3);
        return Math.min(ans1, Math.min(ans2, ans3)) + 1;
    }


    public static int countMinStepsToOneDPRecursion(int n, int[] memo) {
        // base case
        if (n == 1)
            return 0;
        if (memo[n] != -1)
            return memo[n];

        int res = countMinStepsToOneDPRecursion(n - 1, memo);
        if (n % 2 == 0)
            res = Math.min(res,
                    countMinStepsToOneDPRecursion(n / 2, memo));
        if (n % 3 == 0)
            res = Math.min(res,
                    countMinStepsToOneDPRecursion(n / 3, memo));
        memo[n] = 1 + res;
        return memo[n];
    }

    public static int countMinStepsToOneDPR2(int n, int[] memo) {
        // base case
        if (n == 1)
            return 0;
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        int ans3 = Integer.MAX_VALUE;
        memo[1] = 0;

        if (memo[n - 1] == -1) {
            ans1 = countMinStepsToOneDPR2(n - 1, memo);
            memo[n - 1] = ans1;
        } else {
            ans1 = memo[n - 1];
        }

        if (n % 2 == 0) {
            if (memo[n / 2] == -1) {
                ans2 = countMinStepsToOneDPR2(n / 2, memo);
                memo[n / 2] = ans2;
            } else {
                ans2 = memo[n / 2];
            }
        }


        if (n % 3 == 0) {
            if (memo[n / 3] == -1) {
                ans3 = countMinStepsToOneDPR2(n / 3, memo);
                memo[n / 3] = ans3;
            } else {
                ans3 = memo[n / 3];
            }
        }

        return Math.min(Math.min(ans1, ans2), ans3) + 1;
    }

}

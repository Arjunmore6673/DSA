package codingninja.dynamicprogramming;

import java.util.HashMap;

public class ByteLandian {
    public static void main(String[] args) {
//        int n = 12;
//        HashMap<Long, Long> memo = new HashMap<>();
//        System.out.println(bytelandian(n, memo));
//        Set<Integer> set = new HashSet<>();
//        set.add(2);
//        set.add(12);
//        set.add(2);
//        System.out.println(set);
    }


    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        if (n <= 0) return 0;
        if (memo.containsKey(n)) return memo.get(n);
        long ans1 = bytelandian(n / 2, memo);
        long ans2 = bytelandian(n / 3, memo);
        long ans4 = bytelandian(n / 4, memo);
        long total = Math.max(n, ans1 + ans4 + ans2);
        memo.put(n, total);
        return memo.get(n);
    }
}

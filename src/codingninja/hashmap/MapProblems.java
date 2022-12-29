package codingninja.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapProblems {
    public static void main(String[] args) {
//        System.out.println(uniqueChar("ababacd"));
//        int[] arr = {3, 7, 2, 1, 9, 8, 10, 41};
        //   System.out.println(longestConsecutiveIncreasingSequence(arr));
//        int[] arr2 = {5, 1, 2, 4};
        int[] arr2 = {4,4,4,4};
        System.out.println(findPairs(arr2, 0));
    }

    public static String uniqueChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
                result += str.charAt(i);
            }
        }
        return result;
    }

    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
//       initialize map with false value
        for (int v : arr)
            map.put(v, true);
//       check if value present at array minus 1, is present in the Map, If it is then it cannot be
//        our starting point so mark it as false.
        for (int val : arr) {
            if (map.containsKey(val - 1))
                map.put(val, false);
        }
        int maxCount = 0;
        int startValue = 0;
        for (int val : arr) {
//          check consecutive element count and update with max count.
            int tempCount = 1;
            int tempValue = val;
            while (map.containsKey(tempValue + tempCount)) {
                tempCount++;
            }
            if (tempCount > maxCount) {
                maxCount = tempCount;
                startValue = tempValue;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(startValue);
        list.add(startValue + maxCount);
        return list;
    }

    public static int findPairs(int[] arr, int k) {
        HashMap<Integer, Integer> presum = new HashMap<>();

        int sum = 0; // Initialize the sum of elements
        int maxLen = 0; // Initialize result
        int n = arr.length;
        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr[i];

            if (arr[i] == 0 && maxLen == 0)
                maxLen = 1;
            if (sum == 0)
                maxLen = i + 1;

            // Look for this sum in Hash table
            if (presum.containsKey(sum)) {
                // If this sum is seen before, then update maxLen
                maxLen = Math.max(maxLen, i - presum.get(sum));
            } else {
                // Else insert this sum with index in hash table
                presum.put(sum, i);
            }
        }

        return maxLen;
    }

}

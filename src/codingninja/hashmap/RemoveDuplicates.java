package codingninja.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {
    public static void main(String[] args) {
//        ArrayList<Integer> output = removeDuplicates(arr);
//        System.out.println(output);
        int[] arr = {6, 9, 8, 5};
        int[] arr2 = {9, 2, 4, 1, 8};
//        System.out.println(maxOccurrence(arr2));
//        intersection(arr, arr2);
        int[] arrPair = {2, 1, -2, 2, 3};
        System.out.println(pairSum(arrPair, arrPair.length));

    }

    public static int pairSum(int[] input, int n) {
        int count = 0;
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (input[i] + input[j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void intersection(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : arr1) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        }
        System.out.println(map);
        for (Integer i : arr2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
            }
        }

    }

    private static int maxOccurrence(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            if (map.containsKey(v)) {
                int prevCount = map.get(v);
                map.put(v, prevCount + 1);
            } else {
                map.put(v, 1);
            }
        }
        System.out.println(map);
        int maxCount = 0;
        int key = -1;
        for (Map.Entry<Integer, Integer> obj : map.entrySet()) {
            if (obj.getValue() > maxCount) {
                key = obj.getKey();
                maxCount = obj.getValue();
            }
        }
        return key;
    }

    private static ArrayList<Integer> removeDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();
        for (int j : arr) {
            if (!map.containsKey(j)) {
                map.put(j, j);
                output.add(j);
            }
        }
        return output;

    }
}

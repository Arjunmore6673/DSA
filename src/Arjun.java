// Java Program to prints common element in all
// rows of matrix

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Arjun {

    // Specify number of rows and columns
    static int M = 4;
    static int N = 5;

    // prints common element in all rows of matrix
    static void printCommonElements(int[][] mat) {
        int rows = 4;
        int cols = 5;
        // first intilize 1 row with 1
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cols; i++) map.put(mat[0][i], 1);
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map.get(mat[i][j]) != null && map.get(mat[i][j]) == i) {
                    map.put(mat[i][j], map.get(mat[i][j]) + 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> val : map.entrySet())
            if (val.getValue() == rows)
                System.out.print(val.getKey() + " ");
    }

    public static ArrayList<Integer> findCommonElements(ArrayList<ArrayList<Integer>> mat) {
        int rows = mat.size();
        int cols = mat.get(0).size();
        System.out.println(rows + " cols "+ cols);

        ArrayList<Integer> finalList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cols; i++) map.put(mat.get(0).get(i), 1);
        System.out.println(map);
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map.get(mat.get(i).get(j)) != null && map.get(mat.get(i).get(j)) == i) {
                    map.put(mat.get(i).get(j), map.get(mat.get(i).get(j)) + 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> val : map.entrySet())
            if (val.getValue() == rows)
                finalList.add(val.getKey());

        return finalList;

    }

    // Driver code
    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 2, 1, 4, 8},
                        {3, 7, 8, 5, 1},
                        {8, 7, 7, 3, 1},
                        {8, 1, 2, 7, 9},
                };
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>(Arrays.asList(1, 2, 1, 4, 8)));
        list.add(new ArrayList<Integer>(Arrays.asList(3, 7, 8, 5, 1)));
        list.add(new ArrayList<Integer>(Arrays.asList(8, 7, 7, 3, 1)));
        list.add(new ArrayList<Integer>(Arrays.asList(8, 1, 2, 7, 9)));
        System.out.println(findCommonElements(list));
    }
}

// This code contributed by Rajput-Ji

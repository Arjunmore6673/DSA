package codingninja.graphs;

import java.util.Scanner;

public class PrimsAlgo {


    private static int[][] primsAlgo(int[][] adjMatrix, int vertices) {
        int[] parentArr = new int[vertices];
        boolean[] visited = new boolean[vertices];
        int[] weight = new int[vertices];
        weight[0] = 0;
        parentArr[0] = -1;
        for (int i = 1; i < weight.length; i++)
            weight[i] = Integer.MAX_VALUE;

        for (int i = 0; i < vertices; i++) {
            int min = findMinVertex(visited, weight);
            visited[min] = true;
            for (int j = 0; j < vertices; j++) {
                if (!visited[j] && adjMatrix[min][j] != 0) {
                    if (adjMatrix[min][j] < weight[j]) {
                        weight[j] = adjMatrix[min][j];
                        parentArr[j] = min;
                    }
                }
            }
        }
        return null;
    }

    private static int findMinVertex(boolean[] visited, int[] weight) {

        return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        int[][] adjMatrix = new int[vertices][vertices];

        for (int i = 0; i < edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int weight = scanner.nextInt();
            adjMatrix[v1][v2] = weight;
            adjMatrix[v2][v1] = weight;
        }
        int[][] mst = primsAlgo(adjMatrix, vertices);
    }


}

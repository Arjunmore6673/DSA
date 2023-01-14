package codingninja.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphTraversal {

    public static void preOrderOrDFS(int[][] adjMatrix, int currentVertex, boolean[] visited) {
        System.out.print(currentVertex + " ");
        for (int i = currentVertex + 1; i < adjMatrix.length; i++) {
            if (!visited[i] && adjMatrix[currentVertex][i] == 1) {
                preOrderOrDFS(adjMatrix, i, visited);
                visited[i] = true;
            }
        }
    }

    public static void preOrderOrDFS(int[][] adjMatrix) {
        preOrderOrDFS(adjMatrix, 0, new boolean[adjMatrix.length]);
    }

    public static void inOrderOrBFS(int[][] adjMatrix) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjMatrix.length];
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            System.out.print(currentIndex + " ");
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentIndex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt(); // if 4 then vertices is 0,1,2,3
        int edges = scanner.nextInt();
        int[][] adjMatrix = new int[vertices][vertices];
        for (int i = 0; i < edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        for (int[] row : adjMatrix) {
            for (int rowItem : row) System.out.print(rowItem + " ");
            System.out.println();
        }
//        preOrderOrDFS(adjMatrix);
        inOrderOrBFS(adjMatrix);


/* input
4 3
0 1
0 3
1 2
-----------------
   0
 !    !
 2    3
 !    !
 1    4

 5 4
 0 2
 0 3
 2 1
 3 4



 4 4
0 1
0 3
1 2
2 3
1 3
         */
    }
}

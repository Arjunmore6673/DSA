package codingninja.graphs;

import java.util.Scanner;

public class Graphs {
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
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

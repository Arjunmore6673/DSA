package codingninja.graphs;

import java.util.Scanner;


public class GraphsProblems {
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
        int source = scanner.nextInt();
        int dest = scanner.nextInt();
        //hasPath(adjMatrix, source, dest);
        GraphsProblemImplementation graph = new GraphsProblemImplementation();
//        graph.hasPath(adjMatrix, source, dest);
//        System.out.println(graph.getPath(adjMatrix, source, dest));
//        graph.getPathBFS(adjMatrix, source, dest);
//        System.out.print("connected components ");
//        graph.disconnectedGraph(adjMatrix);
//        System.out.println();
       // System.out.println("is graph Connected " + graph.isGraphConnected(adjMatrix));
        ;
    }


}

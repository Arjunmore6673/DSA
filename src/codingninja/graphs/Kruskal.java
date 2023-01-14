package codingninja.graphs;

import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Kruskal {

    private static int findUnion(int v1, int[] parents) {
        if (v1 == parents[v1])
            return v1;
        return findUnion(parents[v1], parents);
    }

    private static Edge[] kruskalAlgorithm(Edge[] edgeArray, int vertices) {
        Arrays.sort(edgeArray);
        Edge[] output = new Edge[vertices - 1];
        int[] parents = new int[vertices];
        for (int i = 0; i < parents.length; i++)
            parents[i] = i;
//        when count is n-1 then we are done with picking edges.
        int count = 0;
        int i = 0;
        while (count != edgeArray.length -1) {
            Edge currentEdge = edgeArray[i++];
            int v1Parent = findUnion(currentEdge.v1, parents);
            int v2Parent = findUnion(currentEdge.v2, parents);
            if (v1Parent != v2Parent) {
                output[count] = currentEdge;
                parents[v1Parent] = v2Parent;
                count++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        Edge[] edgeArray = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int weight = scanner.nextInt();
            Edge ed = new Edge(v1, v2, weight);
            edgeArray[i] = ed;
        }
        System.out.println("input done..!");
        Edge[] mst = kruskalAlgorithm(edgeArray, vertices);
        for (Edge edge : mst) {
            if (edge.v1 < edge.v2)
                System.out.println(edge.v1 + " " + edge.v2 + " " + edge.weight);
            else
                System.out.println(edge.v2 + " " + edge.v1 + " " + edge.weight);
        }
    }

}

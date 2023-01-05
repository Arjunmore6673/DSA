package codingninja.graphs;

import java.util.ArrayList;

public class GraphsProblemImplementation {
    public ArrayList<Integer> getPath(int[][] adjMatrix, int source, int dest) {
        boolean[] visited = new boolean[adjMatrix.length];
        return getPath(adjMatrix, source, dest, visited);
    }
    private ArrayList<Integer> getPath(int[][] adjMatrix, int source, int dest, boolean[] visited) {
        if (source == dest) {
            ArrayList<Integer> paths = new ArrayList<>();
            paths.add(source);
            return paths;
        }
        visited[source] = true;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[source][i] == 1 && !visited[i]) {
                ArrayList<Integer> list = getPath(adjMatrix, i, dest, visited);
                if (list != null) {
                    list.add(source);
                    return list;
                }

            }
        }
        return null;
    }

    public void hasPath(int[][] adjMatrix, int source, int dest) {
        boolean[] visited = new boolean[adjMatrix.length];
        System.out.println(hasPathThere(adjMatrix, source, dest, visited));
    }
    private boolean hasPathThere(int[][] adjMatrix, int currentVertex, int dest, boolean[] visited) {
        if (currentVertex == dest) return true;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                visited[i] = true;
                return hasPathThere(adjMatrix, i, dest, visited);
            }
        }
        return false;
    }


}

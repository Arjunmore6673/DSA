package codingninja.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class GraphsProblemImplementation {
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


    public void getPathBFS(int[][] adjMatrix, int source, int dest) {
        boolean[] visited = new boolean[adjMatrix.length];
        getPathBFS(adjMatrix, source, dest, visited);
    }

    public void getPathBFS(int[][] adjMatrix, int source, int dest, boolean[] visited) {
        ArrayList<Integer> paths = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        queue.add(source);
        visited[source] = true;
        map.put(source, null);
        boolean pathFound = false;
        while (!queue.isEmpty()) {
            int currentIndex = queue.poll();
            paths.add(currentIndex);
            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[currentIndex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    map.put(i, currentIndex);
                    visited[i] = true;
                    if (i == dest) {
                        pathFound = true;
                        break;
                    }
                }
            }
        }
        System.out.println(pathFound);
        if (pathFound)
            getPathFromMap(map, dest);

    }

    public void getPathFromMap(HashMap<Integer, Integer> map, Integer dest) {
        if (dest == null)
            return;
        System.out.print(dest + " ");
        Integer parent = map.get(dest);
        getPathFromMap(map, parent);
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


    public boolean isGraphConnected(int[][] adjMatrix) {
        if (adjMatrix.length == 0) return false;
        boolean[] visited = new boolean[adjMatrix.length];
        isGraphConnected(adjMatrix, 0, visited);
        for (boolean path : visited)
            if (!path) return false;
        return true;
    }

    private void isGraphConnected(int[][] adjMatrix, int source, boolean[] visited) {
        System.out.print(source + " ");
        visited[source] = true;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[source][i] == 1 && !visited[i]) {
                isGraphConnected(adjMatrix, i, visited);
                visited[source] = true;
            }
        }
    }

    public void disconnectedGraph(int[][] adjMatrix) {
        int count =1;
        boolean[] visited = new boolean[adjMatrix.length];
        disconnectedGraph(adjMatrix, 0, visited);
        for (int i = 0;i< visited.length;i++){
            if (!visited[i]){
                count++;
                disconnectedGraph(adjMatrix, i, visited);
            }
        }
        System.out.println("count" + count);
    }

    private void disconnectedGraph(int[][] adjMatrix, int source, boolean[] visited) {
        System.out.print(source + " ");
        visited[source] = true;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[source][i] == 1 && !visited[i]) {
                disconnectedGraph(adjMatrix, i, visited);
            }
        }
    }
}

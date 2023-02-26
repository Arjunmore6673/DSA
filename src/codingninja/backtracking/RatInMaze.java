package codingninja.backtracking;

import java.util.Arrays;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = new int[][]{{1, 1, 0}, {1, 1, 0}, {1, 1, 1}};
        System.out.println(ratInMaze(maze));
    }

    private static boolean ratInMaze(int[][] maze) {
        int[][] path = new int[maze.length][maze[0].length];
        return solveMaze(maze, 0, 0, path);
    }

    private static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
//        check i, j cell valid or not.
        int n = maze.length;
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }
        //include cell in current path;
        path[i][j] = 1;

        //destination cell
        if (i == n - 1 && j == n - 1) {
            System.out.println(Arrays.deepToString(path));
            return true;
        }
//       top
        if (solveMaze(maze, i - 1, j, path)) return true;
//      right
        if (solveMaze(maze, i, j + 1, path)) return true;
//      bottom
        if (solveMaze(maze, i + 1, j, path)) return true;
//      left
        if (solveMaze(maze, i, j - 1, path)) return true;

        return false;
    }
}

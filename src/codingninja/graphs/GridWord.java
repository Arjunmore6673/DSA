package codingninja.graphs;

import java.util.Arrays;

public class GridWord {

    static void createMatrix(int row, String str, int n, int m, char[][] list) {
        for (int i = row; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list[i][j] = str.charAt(j);
            }
        }
    }

    public static void main(String[] args) {
        String[] graph = new String[]{"CXDXNXNXNXA", "XOXIXGXIXJX"};
        int n = 2;
        int m = 11;
        char[][] list = new char[n][m];
        for (int i = 0; i < graph.length; i++)
            createMatrix(i, graph[i], n, m, list);
        System.out.println(Arrays.deepToString(list));
        String chk = "CODINGNINJA";
        System.out.println(exist(list, chk));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean result = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    result = true;
                }
            }
        }

        return result;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return false;
        }

        if (board[i][j] == word.charAt(k)) {
            char temp = board[i][j];
            board[i][j] = '#';
            if (k == word.length() - 1) {
                return true;
            } else if (
                    dfs(board, word, i - 1, j, k + 1, visited)
                            || dfs(board, word, i + 1, j, k + 1, visited)
                            || dfs(board, word, i, j - 1, k + 1, visited)
                            || dfs(board, word, i, j + 1, k + 1, visited)

                            || dfs(board, word, i + 1, j + 1, k + 1, visited)
                            || dfs(board, word, i - 1, j - 1, k + 1, visited)

            ) {
                return true;
            }
            board[i][j] = temp;
        }

        return false;
    }
}

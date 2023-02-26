package codingninja.object4.tickTack;

public class Board {
    final char EMPTY = '-';
    char[][] board;
    int boardSize = 3;
    int count = 0;
    char p1Symbol;
    char p2Symbol;

    public Board(char p1Symbol, char p2Symbol) {
        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++)
                board[i][j] = EMPTY;
        }
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
        print();
    }

    public int ans(char symbol) {
        return symbol == p1Symbol ? STATUS.PLAYER_1_WINS : STATUS.PLAYER_2_WINS;
    }

    public int move(char symbol, int x, int y) {
        if (x < 0 || x >= boardSize || y < 0 || y >= boardSize || board[x][y] != EMPTY)
            return STATUS.INVALID_MOVE;
        board[x][y] = symbol;
        count++;
        if (board[x][0] == board[x][1] && board[x][1] == board[x][2]) {
            System.out.println("row wise..!");
            return ans(symbol);
        }
        if (board[0][y] == board[1][y] && board[1][y] == board[2][y]) {
            System.out.println("column wise..!");
            return ans(symbol);
        }

        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            System.out.println("digonal wise..!");
            return ans(symbol);
        }
        if (board[2][0] != EMPTY && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            System.out.println("digonal wise..!2 ");
            return ans(symbol);
        }
        if (boardSize * boardSize == count) // 3x3 matrix = 9 cells.
            return STATUS.DRAW;
        return STATUS.INCOMPLETE;
    }


    public void print() {
        System.out.println("_______________");
        for (char[] row : board) {
            for (char item : row)
                System.out.print("|" + item );
            System.out.println();
        }
        System.out.println("_______________");
    }
}

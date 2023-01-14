package codingninja.object4.tickTack;

public class Board {
    final char EMPTY = ' ';
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
    }

    public int move(char symbol, int x, int y) {
        return 1;
    }
}

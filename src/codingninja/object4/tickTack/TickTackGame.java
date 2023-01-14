package codingninja.object4.tickTack;

import java.util.Scanner;

public class TickTackGame {

    Player p1, p2;
    Board board;

    public static void main(String[] args) {
        TickTackGame tickTackGame = new TickTackGame();
        tickTackGame.startGame();

    }

    private void startGame() {
//      take player input.
        p1 = takePlayerInput(1);
        p2 = takePlayerInput(2);
        while (p1.getSymbol() == p2.getSymbol()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Symbol cannot be same enter different symbol");
            p2.setSymbol(scanner.next().charAt(0));
        }
//      create the board.
        board = new Board(p1.symbol, p2.symbol);
//        play the game.
        boolean player1Turn = true;
        int status = STATUS.INCOMPLETE;
        while (board.count == board.boardSize ) {
            Scanner scanner = new Scanner(System.in);
            if (player1Turn) {
                System.out.println("Player 1 " + p1.getPlayerName() + " 's turn");
                System.out.println("Enter x");
                int x = scanner.nextInt();
                System.out.println("Enter Y");
                int y = scanner.nextInt();
                 status = board.move(p1.getSymbol(), x, y);
                if (STATUS.INVALID_MOVE == status) {
                    System.out.println("invalid move please try again.");
                }else {
                    player1Turn = false;
                }
            } else {
                System.out.println("Player 2 " + p2.getPlayerName() + " 's turn");
                System.out.println("Enter x");
                int x = scanner.nextInt();
                System.out.println("Enter Y");
                int y = scanner.nextInt();
                 status = board.move(p2.getSymbol(), x, y);
                if (STATUS.INVALID_MOVE == status) {
                    System.out.println("invalid move please try again.");
                }
                player1Turn = true;
            }
            if (status == STATUS.PLAYER_1_WINS || status == STATUS.PLAYER_2_WINS)
                break;
        }
    }

    private Player takePlayerInput(int playerNo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + playerNo + "Player Name : ");
        String name = scanner.next();
        System.out.println("Enter " + playerNo + "Player symbol : ");
        char symbol = scanner.next().charAt(0);
        return new Player(name, symbol);
    }
}

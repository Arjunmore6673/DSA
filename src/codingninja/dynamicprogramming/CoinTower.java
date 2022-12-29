package codingninja.dynamicprogramming;

public class CoinTower {

    static final int Beerus = 1;
    static final int Whis = 0;

    public static void main(String[] args) {


        int result = findWinner(4, 2, 3);
        if (result == 1) {
            System.out.println("Berrus");
        } else {
            System.out.println("whip");
        }

    }

    static int findWinner(int n, int x, int y) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        int ans = -1;
        return n;
    }

}

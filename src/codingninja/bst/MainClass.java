package codingninja.bst;


public class MainClass {
    static int function(int m) {
        if (m <= 1) return 1;
        if (m % 2 == 0) return function(m / 2);
        return function(m / 2) + (function(m / 2) + 1);
    }

    public static void main(String[] args) {
        System.out.println(function(11));
        ;
    }
}

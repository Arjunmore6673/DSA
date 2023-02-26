package quizes.strings;

/*
For a given input string(str), write a function to print all the possible substrings.

Sample Input 1:

abc

Sample Output 1:

a
ab
abc
b
bc
c

*/
public class AllSubstrings {


    public static void printSubstrings(String str) {
        for (int i = 0; i <= str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                System.out.println(str.substring(i, j));
            }
        }

    }
}

package quizes.strings.problems;
/*Aadil has been provided with a sentence in the form of a string as a function parameter.
 The task is to implement a function so as to print the sentence such that each word in the sentence is reversed.
        Example:
        Input Sentence: "Hello, I am Aadil!"
        The expected output will print, ",olleH I ma !lidaA".
Sample Input 1:
Welcome to Coding Ninjas

Sample Output 1:
emocleW ot gnidoC sajniN

*/

public class ReverseEachWord {

    public static String reverseEachWord(String input) {
        int start = 0;
        int end = input.length();
        String output = "";
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == ' ') {
                end = i;
                String str = input.substring(start, end);
                String result = "";
                for (int j = str.length() - 1; j >= 0; j--)
                    result += str.charAt(j);
                output += result + " ";
                start = i + 1;
            }

        }
        String a = input.substring(start, input.length());
        String result = "";
        for (int j = a.length() - 1; j >= 0; j--)
            result += a.charAt(j);

        return output += result;
    }
}

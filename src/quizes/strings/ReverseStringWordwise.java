package quizes.strings;

/*
Reverse the given string word wise. That is, the last word in given string should come at 1st place,
last second word at 2nd place and so on. Individual words should remain as it is.

Sample Input 1:
Welcome to Coding Ninjas

Sample Output 1:
Ninjas Coding to Welcome


*/
public class ReverseStringWordwise {

    public static String reverseWordWise(String input) {
        int start = 0;
        int end = input.length();
        String output = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == ' ') {
                start = i + 1;
                output += input.substring(start, end) + " ";
                end = start - 1;
            }
        }
        output += input.substring(0, end);
        return output;
    }
}

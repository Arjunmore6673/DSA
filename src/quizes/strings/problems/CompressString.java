package quizes.strings.problems;

/*
Write a program to do basic string compression. For a character which is consecutively repeated more than once, replace consecutive duplicate occurrences with the count of repetitions.
Example:
If a string has 'x' repeated 5 times, replace this "xxxxx" with "x5".
The string is compressed only when the repeated character count is more than 1.

Sample Input 1:
aaabbccdsa
Sample Output 1:
a3b2c2dsa
*/
public class CompressString {


    public static String getCompressedString(String str) {
        String output = "";
        String temp = " ";
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            char prev = temp.charAt(temp.length() - 1);
            if (prev != current) {
                int count = 1;
                for (int j = i + 1; j < str.length() && str.charAt(j) == current; j++) {
                    count++;
                }
                if (count >= 2) {
                    output += String.valueOf(current) + count;
                } else {
                    output += current;
                }
                temp += String.valueOf(current);
            }

        }
        return output;
    }

}

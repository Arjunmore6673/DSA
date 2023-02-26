package quizes.strings.problems;
/*For a given a string(str)and a character X,write a function
to remove all the occurrences of X from the given string.
        The input string will remain unchanged if the given character(X)doesn't exist in the input string
Sample Input 1:
aabccbaa
a

Sample Output 1:
bccb


*/

public class RemoveCharacter {

    public static String removeAllOccurrencesOfChar(String str, char ch) {
        String output = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch)
                output += str.charAt(i);
        }
        return output;
    }
}

package quizes.strings.problems;
/*
For a given string(str), remove all the consecutive duplicate characters.
        Example:

        Input String: "aaaa"
        Expected Output: "a"

        Input String: "aabbbcc"
        Expected Output: "abc"

Sample Input 1:
aabccbaa

Sample Output 1:
abcba


*/

public class RemoveConsecutiveDuplicates {
    public static String removeConsecutiveDuplicates(String str) {
        int n = str.length();
        if (n == 0) {
            return str;
        }
        String answer = "";
        int startIndex = 0;
        while (startIndex < n) {
            char uniqueChar = str.charAt(startIndex);
            int nextUniqueCharIndex = startIndex + 1;
            while (nextUniqueCharIndex < n && str.charAt(nextUniqueCharIndex) == uniqueChar) {
                nextUniqueCharIndex += 1;
            }
            answer += uniqueChar;
            startIndex = nextUniqueCharIndex;
        }
        return answer;
    }
}

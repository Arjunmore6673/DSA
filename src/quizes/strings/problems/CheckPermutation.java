package quizes.strings.problems;
import java.util.*;

/*
For a given two strings, 'str1' and 'str2', check whether they are a permutation of each other or not.

Permutations of each other
Two strings are said to be a permutation of each other when either of the string's characters
can be rearranged so that it becomes identical to the other one.
Example:
str1= "sinrtg"
str2 = "string"
The character of the first string(str1) can be rearranged to form str2 and hence we can say that the given strings are a permutation of each othe


Sample Input 1:
abcde
baedc

Sample Output 1:
true

Sample Input 2:
abc
cbd

Sample Output 2:
false

*/
public class CheckPermutation {
    public static String sortString(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr) ;
        return String.valueOf(charArr);
    }

    public static boolean isPermutation(String str1, String str2) {
        str1 = sortString(str1);
        str2 = sortString(str2);
        boolean output = str1.equals(str2);
        return output;
    }
}

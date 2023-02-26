package quizes.strings.problems;
/*
For a given a string(str), find and return the highest occurring character.
Example:

Input String: "abcdeapapqarr"
Expected Output: 'a'
Since 'a' has appeared four times in the string which happens to be the highest frequency character, the answer would be 'a'.

Sample Input 1:
abdefgbabfba
Sample Output 1:
b


*/
public class HighestOccuringCharacter {
    public static char highestOccuringChar(String str) {
        int count=0;
        char current='a';
        int len = str.length();
        String skip="";
        for(int i=0;i<len;i++){
            char iChar= str.charAt(i);
            if(!skip.contains(String.valueOf(iChar)))
            {
                int cnt=0;
                for(int j=i+1;j<len;j++)
                    if(iChar == str.charAt(j)) cnt++;
                skip += String.valueOf(iChar);
                if(cnt > count){
                    count = cnt;
                    current=iChar;
                }
            }

        }
        // System.out.print(maxIndex +" ");
        // System.out.print(count +" ");
        // System.out.print(current +" ");
        return current;
    }


}

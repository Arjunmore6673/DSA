package quizes.strings;

public class StringPalindrome {

    public static boolean isPalindrome(String str) {
        String revStr ="";
        for(int i=str.length()-1;i>=0;i--){
            revStr+=str.charAt(i);
        }
        return revStr.equals(str);
    }

}

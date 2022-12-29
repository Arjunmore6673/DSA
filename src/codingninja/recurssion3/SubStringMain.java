package codingninja.recurssion3;

import java.util.ArrayList;
import java.util.Arrays;

public class SubStringMain {

    private static String[] subSequences(String str) {
        if (str.length() == 0) {
            //base case;
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = subSequences(str.substring(1));
        String[] output = new String[smallOutput.length * 2];
        /// copy character as it is
        for (int i = 0; i < smallOutput.length; i++)
            output[i] = smallOutput[i];
        /// copy character again by adding first char at front of it.
        for (int j = 0; j < smallOutput.length; j++)
            output[smallOutput.length + j] = str.charAt(0) + smallOutput[j];
        return output;
    }


    private static String getOptions(int lastDigit) {
        switch (lastDigit) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return "";
        }
    }

    private static String[] keypadCombinations(int input) {
        if (input == 0) {
            //base case;
            String[] output = new String[1];
            output[0] = "";
            return output;
        }
        String[] smallOutput = keypadCombinations(input / 10);
        int lastDigit = input % 10;
        String numberOptions = getOptions(lastDigit);
        String[] output = new String[smallOutput.length * numberOptions.length()];
        int k = 0;
        for (int j = 0; j < smallOutput.length; j++) {
            for (int i = 0; i < numberOptions.length(); i++) {
                output[k++] = smallOutput[j] + numberOptions.charAt(i);
            }
        }
        return output;
    }

    private static void minimumInArray(int[] arr, int start, int min) {
        if (start == arr.length) {
            System.out.println(min);
            return;
        }
        min = Math.min(min, arr[start]);
        minimumInArray(arr, start + 1, min);
    }
//    c b bc a ac ab abc

    private static void subSequencesWithoutArr(String str, String stringSoFar) {
        if (str.length() == 0) {
            System.out.print(stringSoFar + " ");
            return;
        }
        String smallStr = str.substring(1);
        subSequencesWithoutArr(smallStr, stringSoFar + str.charAt(0));
        subSequencesWithoutArr(smallStr, stringSoFar);
    }

    public static void printKeypadWithoutArr(int input, String ansTillNow) {
        if (input == 0) {
            System.out.println(ansTillNow + " ");
            return;
        }
        int lastDigit = input % 10;
        int smallInput = input / 10;
        String options = getOptions(lastDigit);

        for (int i = 0; i < options.length(); i++)
            printKeypadWithoutArr(smallInput, options.charAt(i) + ansTillNow);
    }

    public static void main(String[] args) {
//        String str = "abc";
//        System.out.println(Arrays.toString(subSequences(str)));
//        System.out.println(Arrays.toString(keypadCombinations(22)));
//        minimumInArray(new int[]{22,3,42,422}, 0, Integer.MAX_VALUE);
//        subSequencesWithoutArr(str, "");
//        printKeypadWithoutArr(23, "");
        int input[] = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int target = 6;
        String set = "";
        int sum = 0;
        int index = 0;
//        subsetsSumK(input, index, set, sum, target);
//        System.out.println(Arrays.deepToString(subsets(new int[]{15, 20, 12}, 0)));
        permutationString("abc", "");
        ArrayList<String> result = new ArrayList<>();
        System.out.println(Arrays.toString(permutationStringReturnArray("abc", "", result)));
        ;
    }

    private static String[] permutationStringReturnArray(String str, String ans, ArrayList<String> result) {
        if (str.length() == 0) {
            result.add(ans);
            return result.toArray(new String[0]);
        }
        for (int i = 0; i < str.length(); i++) {
//            first character
            char c = str.charAt(i);
//            rest of string excluding first character.
            String restOfString = str.substring(0, i) + str.substring(i + 1);
            permutationStringReturnArray(restOfString, ans + c, result);
        }
        return result.toArray(new String[0]);
    }

    private static void permutationString(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
//            first character
            char c = str.charAt(i);
//            rest of string excluding first character.
            String restOfString = str.substring(0, i) + str.substring(i + 1);
            permutationString(restOfString, ans + c);
        }
    }

    public static int[][] subsets(int input[], int index) {
        if (index == input.length) {
            int[][] myAns = new int[1][0];
            return myAns;
        }
        int[][] smallAns = subsets(input, index + 1);
        int[][] ans = new int[2 * smallAns.length][];
        int k = 0;
        int len = smallAns.length;
        for (int i = 0; i < len; i++) {
            ans[k] = new int[smallAns[i].length];
            for (int j = 0; j < smallAns[i].length; j++) {
                ans[k][j] = smallAns[i][j];
            }
            k++;
        }
        for (int i = 0; i < len; i++) {
            ans[k] = new int[smallAns[i].length + 1];
            ans[k][0] = input[index];
            for (int j = 1; j <= smallAns[i].length; j++) {
                ans[k][j] = smallAns[i][j - 1];
            }
            k++;
        }
        return ans;
    }

    private static void subsetsSumK(int[] input, int index, String set, int sum, int target) {
        if (index == input.length) {
            if (sum == target) System.out.println(set);
            return;
        }
        subsetsSumK(input, index + 1, set, sum, target);
        subsetsSumK(input, index + 1, set + input[index], sum + input[index], target);
    }


}

package codingninja.bst;

public class test {
    public static void main(String[] args) {
        int count = 0;
        int index = 0;
        String s2 = "h";
        String s1 = "e";
        boolean isExist = true;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (isExist) {
                for (int j = index; j < s1.length(); j++) {
                    char c2 = s1.charAt(j);
                    if (c == c2) {
                        index= j;
                        count++;
                        isExist =true;
                    }else {
                        isExist=false;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

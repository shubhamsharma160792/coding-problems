package com.java.string;

public class LengthOfLastWord {

    private int lengthOfLastWord(final String A) {
        int strLen = A.length();
        int len = 0;
        boolean wordStarted = false;
        for (int i = strLen - 1; i >= 0; i--) {
            if (A.charAt(i) != ' ') {
                wordStarted = true;
                len++;
            }
            else if (wordStarted)
                return len;
            if (i == 0)
                return len;
        }
        return 0;
    }

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();
        String A = "Hello World  ";
        System.out.println(obj.lengthOfLastWord(A));
    }

}

package com.java.string;

public class AmazingSubstring {

    private static boolean isVowel(Character c) {
        String vowel = "aeiouAEIOU";
        if (vowel.contains(Character.toString(c)))
            return true;
        return false;
    }

    public int solve(String A) {
        int total = 0;
        char c;
        for (int i = 0; i < A.length(); i++) {
            c = A.charAt(i);
            if (isVowel(c))
                total += A.length() - i;
        }
        return total;
    }

    public static void main(String[] args) {
        AmazingSubstring obj = new AmazingSubstring();
        String str = "ABEC";
        System.out.println(obj.solve(str));
    }

}

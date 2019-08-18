package com.java.string.palindrome;

public class LongestPalindromicSubstring {

    private static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1))
                return false;
        }
        return true;
    }

    private String doTask(String input) {
        String result = "";
        int longestSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                String current = input.substring(i, j + 1);
                if (isPalindrome(current)) {
                    if (longestSoFar < j - i) {
                        longestSoFar = j - 1;
                        result = current;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        String input = "babababa";
        System.out.println("Longest Palindromic Substring: " + obj.doTask(input));
    }

}

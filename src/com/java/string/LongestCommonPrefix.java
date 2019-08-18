package com.java.string;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> A) {
        String first = A.get(0);
        char c;
        boolean flag = true;
        int i = 0;
        while (flag) {
            if (i >= first.length()) {
                flag = false;
                break;
            }
            c = first.charAt(i);
            for (String str : A) {
                if (i >= str.length() || str.charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                i++;
        }
        return first.substring(0, i);
    }

    public static void main(String[] args) {
        ArrayList<String> A = new ArrayList<>(Arrays.asList("abcdefgh", "abcghijk", "abcefgh"));
        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(A));
    }

}

package com.java.string;

public class PalindromicString {

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public int isPalindrome(String A) {
        int i = 0;
        int j = A.length() - 1;
        char a, b;
        while (i < j) {
            a = Character.toLowerCase(A.charAt(i));
            b = Character.toLowerCase(A.charAt(j));
            if (!isLetterOrDigit(a)) {
                i++;
                continue;
            }
            if (!isLetterOrDigit(b)) {
                j--;
                continue;
            }
            if (a != b)
                return 0;
            i++;
            j--;
        }
        return 1;
    }

    public static void main(String[] args) {
        PalindromicString obj = new PalindromicString();
        String str = "A man, a plan, a canal: Panama";
        System.out.println(obj.isPalindrome(str));

    }

}

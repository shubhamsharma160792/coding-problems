package com.java.simple;

public class FindSquareRoot {

    public Integer findSquareRoot(int x) {
        try {

            // Base case
            if (x == 0 || x == 1)
                return x;
            int i = 1, result = 1;
            while (result <= x) {
                i++;
                result = i * i;
            }
            return i - 1;
        }
        catch (Exception e) {
            return null;
        }
    }
    public static void main(String[] args) {
        FindSquareRoot obj = new FindSquareRoot();
        System.out.println(obj.findSquareRoot(2));
    }
}

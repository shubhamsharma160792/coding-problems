package com.java.math;

public class GCDOfTwoNumbers {

    private int gcd(int m, int n) {
        if (n == 0)
            return m;
        return gcd(n, m % n);
    }

    public static void main(String[] args) {
        GCDOfTwoNumbers obj = new GCDOfTwoNumbers();
        int m = 60, n = 40;
        System.out.printf("GCD of two numbers %d, & %d is : %d", m, n, obj.gcd(m, n));
    }

}

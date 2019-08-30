package com.java.math;

public class LargestCoPrimeDivisor {

    private int gcd(int m, int n) {
        if (n == 0)
            return m;
        return gcd(n, m % n);
    }

    public int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            A = A / gcd(A, B);
        }
        return A;
    }

    public static void main(String[] args) {
        LargestCoPrimeDivisor obj = new LargestCoPrimeDivisor();
        int m = 30;
        int n = 12;
        System.out.printf("largest co-prime factor of %d & %d is: %d ", m, n, obj.cpFact(m, n));
    }

}

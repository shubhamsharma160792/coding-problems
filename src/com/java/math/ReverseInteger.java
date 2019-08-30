package com.java.math;

public class ReverseInteger {

    public int reverse(int A) {
        long result = 0;
        while (A != 0) {
            result = result * 10 + A % 10;
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
                return 0;
            A = A / 10;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        ReverseInteger obj = new ReverseInteger();
        int val = 12345;
        System.out.println(obj.reverse(val));
    }

}

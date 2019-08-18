package com.java.simple;

public class SquareRootBinarySearch {

    private long doTask(int a) {
        if (a < 2)
            return a;
        long start = 1, end = a / 2;
        long mid = 0, result = 0, sqr = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            sqr = mid * mid;
            if (sqr == a)
                return mid;
            else if (sqr < a) {
                start = mid +1;
                result = mid;
            }else{
                end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquareRootBinarySearch obj = new SquareRootBinarySearch();
        System.out.println(obj.doTask(2147483647));
    }

}

package com.java.array;

public class MedianOfTwoSortedArrayV2 {

    public static void main(String[] args) {
        MedianOfTwoSortedArrayV2 obj = new MedianOfTwoSortedArrayV2();
        int[] x = { 1, 2 };
        int[] y = { 3, 4 };
        System.out.println(obj.doTask(x, y));
    }

    private double doTask(int[] x, int[] y) {
        if (x.length > y.length)
            return doTask(y, x);

        int l = 0, h = x.length;
        while (l <= h) {
            int partitionA = (l + h) / 2;
            int partitionB = (x.length + y.length + 1) / 2 - partitionA;
            
            int maxA = partitionA == 0 ? Integer.MIN_VALUE : x[partitionA - 1];
            int maxB = partitionB == 0 ? Integer.MIN_VALUE : y[partitionB - 1];

            int minA = partitionA == x.length ? Integer.MAX_VALUE : x[partitionA];
            int minB = partitionB == y.length ? Integer.MAX_VALUE : y[partitionB];

            if (maxA <= minB && maxB <= minA) {
                if ((x.length + y.length) % 2 == 0)
                    return (double) (Math.max(maxA, maxB) + Math.min(minA, minB)) / 2;
                else
                    Math.max(maxA, maxB);
            }
            else if (maxA > minB) {
                h = partitionA - 1;
            }
            else {
                l = partitionA + 1;
            }
        }
        return -1;
    }
}

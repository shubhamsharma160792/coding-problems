package com.java.array;

public class MedianOfTwoSortedArray {

    private double doTask(int[] x, int[] y) {
        if (x.length > y.length)
            return doTask(y, x);

        int low = 0, high = x.length;
        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (x.length + y.length + 1) / 2 - partitionA;
            
            int maxA = partitionA == 0 ? Integer.MIN_VALUE : x[partitionA - 1];
            int maxB = partitionB == 0 ? Integer.MIN_VALUE : y[partitionB - 1];

            int minA = partitionA == x.length ? Integer.MAX_VALUE : x[partitionA];
            int minB = partitionB == y.length ? Integer.MAX_VALUE : y[partitionB];

            if (maxA <= minB && maxB <= minA) {
                if ((x.length + y.length) % 2 == 0)
                    return (double) (Math.max(maxA, maxB) + Math.min(minA, minB)) / 2;
                else
                    return Math.max(maxA, maxB);
            }
            else if (maxA > minB) {
                high = partitionA - 1;
            }
            else {
                low = partitionA + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray obj = new MedianOfTwoSortedArray();
        int[] x = { 1, 2 };
        int[] y = { 3, 4 };
        System.out.println(obj.doTask(x, y));
    }

}

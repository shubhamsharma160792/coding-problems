package com.java.array;

public class MinimiseTheAbsoluteDifference {

    private int doTask(int[] A, int[] B, int[] C) {
        int i = A.length - 1;
        int j = B.length - 1;
        int k = C.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int diff = 0;
        while (i > -1 && j > -1 && k >= -1) {
            int maxValue = Math.max(A[i], Math.max(B[j], C[k]));
            int minValue = Math.min(A[i], Math.min(B[j], C[k]));
            diff = Math.abs(maxValue - minValue);
            if (diff < minDiff)
                minDiff = diff;
            if (maxValue == A[i])
                i--;
            else if (maxValue == B[j])
                j--;
            else
                k--;
        }
        return minDiff;
    }
    public static void main(String[] args) {
        MinimiseTheAbsoluteDifference obj = new MinimiseTheAbsoluteDifference();
        int[] A = { 1, 4, 5, 8, 10 };
        int[] B = { 6, 9, 15 };
        int[] C = { 2, 3, 6, 6 };
        System.out.printf("Min. diff: %d", obj.doTask(A, B, C));
    }

}

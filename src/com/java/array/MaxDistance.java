package com.java.array;

public class MaxDistance {

    // O(n2)
    private Integer doTask(int[] array) {
        int maxDiff = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] > array[i] && (j - i) > maxDiff) {
                    maxDiff = j - i;
                }
            }
        }
        return maxDiff;
    }

    private Integer doTaskOptimised(int[] array) {
        int maxDiff = 0;
        Integer[] minFromLeftMap = new Integer[array.length];
        Integer[] maxFromRightMap = new Integer[array.length];
        minFromLeftMap[0] = array[0];
        maxFromRightMap[array.length - 1] = array[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            minFromLeftMap[i] = Math.min(minFromLeftMap[i - 1], array[i]);
        }
        for (int i = array.length - 2; i >= 0; i--) {
            maxFromRightMap[i] = Math.max(maxFromRightMap[i + 1], array[i]);
        }
        int i = 0, j = 0;
        while (i < array.length && j < array.length) {
            if (minFromLeftMap[i] < maxFromRightMap[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            }
            else {
                i++;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        MaxDistance obj = new MaxDistance();
        int[] array = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        System.out.println(obj.doTaskOptimised(array));
    }

}

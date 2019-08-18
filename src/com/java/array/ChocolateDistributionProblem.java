package com.java.array;

import java.util.Arrays;

public class ChocolateDistributionProblem {

    private Integer doTask(int[] array, int m) {
        Arrays.sort(array);
        int size = array.length;
        if (size < m) {
            return -1;
        }
        int diff = 0, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= size - m; i++) {
            diff = array[i + m - 1] - array[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] array = { 17, 83, 59, 25, 38, 63, 25, 1, 37 };
        int m = 9;
        ChocolateDistributionProblem obj = new ChocolateDistributionProblem();
        System.out.println(obj.doTask(array, m));
    }

}

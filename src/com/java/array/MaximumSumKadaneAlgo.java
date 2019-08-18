package com.java.array;

public class MaximumSumKadaneAlgo {

    private int doTask(int[] arr) {
        int maximumSum = Integer.MIN_VALUE;
        int sumSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            sumSoFar = sumSoFar + arr[i];
            if (maximumSum < sumSoFar) {
                maximumSum = sumSoFar;
            }
            if (sumSoFar < 0) {
                sumSoFar = 0;
            }


        }
        return maximumSum;
    }

    public static void main(String[] args) {
        MaximumSumKadaneAlgo obj = new MaximumSumKadaneAlgo();
        int[] arr = { -18, -5, -10, -4, -6 };
        System.out.printf("maximum sum %d", obj.doTask(arr));
    }

}

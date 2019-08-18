package com.java.array;

public class KadaneAlgorithm {

    private Integer doTask(int[] arr) {
        int maxSoFar = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar += arr[i];
            if (maxSoFar > maxValue) {
                maxValue = maxSoFar;
            }
            if (maxSoFar < 0) {
                maxSoFar = 0;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        KadaneAlgorithm obj = new KadaneAlgorithm();
        int[] array = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.print(obj.doTask(array));
    }

}

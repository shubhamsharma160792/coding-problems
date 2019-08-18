package com.java.array;

public class TrappingWaterProblem {

    private int doTask(int[] array) {
        int size = array.length;
        int[] maxRightMap = new int[size];
        int maxFromRight = 0;
        int maxFromLeft = 0;
        for (int i = size - 1; i > 0; i--) {
            maxRightMap[i] = maxFromRight;
            if (array[i] > maxFromRight) {
                maxFromRight = array[i];
            }
        }
        int totalWater = 0;
        for (int i = 0; i < size; i++) {
            int value = Math.min(maxFromLeft, maxRightMap[i]);
            if (maxFromLeft < array[i]) {
                maxFromLeft = array[i];
            }
            int diff = value - array[i];
            if (diff > 0)
                totalWater += diff;
        }
        return totalWater;
    }

    public static void main(String[] args) {
        TrappingWaterProblem obj = new TrappingWaterProblem();
        int[] array = { 3, 0, 0, 2, 0, 4 };
        System.out.println(obj.doTask(array));
    }
}

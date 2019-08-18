package com.java.array;

public class EquilibriumPointInArray {

    private int doTask(int[] array) {
        int sum = 0, leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            sum = sum - array[i];
            if (sum == leftSum) {
                return i + 1;
            }
            leftSum += array[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        EquilibriumPointInArray obj = new EquilibriumPointInArray();
        int[] array = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(obj.doTask(array));
    }
}

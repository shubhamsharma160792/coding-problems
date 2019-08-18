package com.java.array;

public class AlternateRearrangeSortedArray {

    private int[] doTask(int[] array) {
        int size = array.length;
        int[] result = new int[size];
        int index = 0, i = 0, j = 0;
        boolean toggle = true;
        while (index < size) {
            if (toggle) {
                result[index] = array[size - i - 1];
                i++;
                toggle = false;
            }
            else {
                result[index] = array[j];
                j++;
                toggle = true;
            }
            index++;
        }
        return result;
    }

    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AlternateRearrangeSortedArray obj = new AlternateRearrangeSortedArray();
        int[] array = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int[] result = obj.doTask(array);
        obj.print(result);
    }

}

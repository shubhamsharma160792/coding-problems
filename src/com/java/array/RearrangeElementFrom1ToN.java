package com.java.array;

public class RearrangeElementFrom1ToN {

    private void doTask(int[] array) {
        int size = array.length;
        int max = array[size - 1];
        int min = array[0];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                array[i] = max;
                max -= 1;
            }
            else {
                array[i] = min;
                min += 1;
            }
        }
    }

    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RearrangeElementFrom1ToN obj = new RearrangeElementFrom1ToN();
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        obj.doTask(array);
        obj.print(array);
    }

}

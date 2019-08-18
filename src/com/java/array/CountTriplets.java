package com.java.array;

import java.util.Arrays;

public class CountTriplets {

    private Integer doTask(int[] array) {
        Arrays.sort(array);
        int size = array.length;
        int counter = 0;
        for (int i = 0; i < size - 1; i++) {
            int l = i + 1;
            int h = size - 1;
            while (l < h) {
                if (array[i] + array[l] == array[h]) {
                    counter++;
                    h--;
                }
                else if (array[i] + array[l] < array[h]) {
                    l++;
                }
                else if (array[i] + array[l] > array[h]) {
                    h--;
                }
            }
        }
        return (counter == 0) ? -1 : counter;
    }

    public static void main(String[] args) {
        CountTriplets obj = new CountTriplets();
        int[] array = { 7, 2, 5, 4, 3, 6, 1, 9, 10, 12 };
        System.out.println(obj.doTask(array));
    }

}

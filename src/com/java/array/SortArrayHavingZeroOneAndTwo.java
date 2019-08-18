package com.java.array;

public class SortArrayHavingZeroOneAndTwo {

    private void doTask(int[] arr) {
        int[] counter = new int[3];
        for (int i = 0; i < arr.length; i++) {
            counter[arr[i]]++;
        }
        int k = 0, i = 0;
        while (i < counter.length) {
            if (k == counter[i]) {
                i++;
                k = 0;
            }
            else {
                System.out.print(i + " ");
                k++;
            }
        }
    }

    public static void main(String[] args) {
        SortArrayHavingZeroOneAndTwo obj = new SortArrayHavingZeroOneAndTwo();
        int[] arr = { 0, 2, 2, 2, 0, 1, 0, 1, 1, 2, 0 };
        obj.doTask(arr);
    }

}

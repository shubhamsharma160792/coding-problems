package com.java.array;

public class MergeTwoSortedArray {

    private int[] doTask(int[] mArray, int[] nArray) {
        int m = mArray.length;
        int n = nArray.length;
        int i = 0, j = 0;
        int[] rArray = new int[m + n];
        int index = 0;
        while (i < m && j < n) {
            if (mArray[i] < nArray[j]) {
                rArray[index] = mArray[i];
                index++;
                i++;
            }
            else {
                rArray[index] = nArray[j];
                index++;
                j++;
            }
        }
        while (i < m) {
            rArray[index] = mArray[i];
            i++;
            index++;
        }
        while (j < n) {
            rArray[index] = nArray[j];
            j++;
            index++;
        }
        return rArray;
    }

    private void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeTwoSortedArray obj = new MergeTwoSortedArray();
        int[] mArray = { 1, 3, 5, 7 };
        int[] nArray = { 0, 2, 6, 8, 9 };
        int[] rArray = obj.doTask(mArray, nArray);
        obj.print(rArray);
    }

}

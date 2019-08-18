package com.java.array.rotation;

//Space: O(1) & Time: O(n)
//Right rotation
public class RotateArray {

    private void reverse(int[] array, int l, int r) {
        if (array == null || array.length == 1)
            return;
        while (l < r) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
    }

    private void doTask(int[] array, int k) {
        int subLength = array.length - k;
        reverse(array, 0, subLength - 1);
        reverse(array, subLength, array.length - 1);
        reverse(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] array = { 1, 2, 3, 4, 5, 6 };
        obj.doTask(array, 2);
        for (int val : array)
            System.out.print(val + " ");
    }

}

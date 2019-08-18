package com.java.array;

public class DutchNationalFlagProblem {

    private void doTask(int[] arr) {
        int l = 0, h = arr.length - 1, m = 0;
        while (m <= h) {
            if (arr[m] == 0) {
                int temp = arr[m];
                arr[m] = arr[l];
                arr[l] = temp;
                l++;
                m++;
            }
            else if (arr[m] == 1) {
                m++;
            }
            else if (arr[m] == 2) {
                int temp = arr[m];
                arr[m] = arr[h];
                arr[h] = temp;
                h--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        DutchNationalFlagProblem obj = new DutchNationalFlagProblem();
        int[] arr = { 0, 2, 2, 1, 0, 1, 0, 1 };
        obj.doTask(arr);
    }
}

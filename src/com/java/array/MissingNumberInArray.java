package com.java.array;

public class MissingNumberInArray {

    private int doTask(int[] arr, int num) {
        int reqSum = num * (num + 1) / 2;
        int arraySum = 0;
        for (int i = 0; i < arr.length; i++) {
            arraySum += arr[i];
        }
        return reqSum - arraySum;
    }

    public static void main(String[] args) {
        MissingNumberInArray obj = new MissingNumberInArray();
        int[] arr = { 2 };
        System.out.printf("Missing number is %d", obj.doTask(arr, 2));
    }
}

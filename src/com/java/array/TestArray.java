package com.java.array;

public class TestArray {

    private Integer findMissingNumber(int[] array) {
        int arraySum = 0;
        int num = array.length;
        int sum = (num + 1) * (num + 2) / 2;
        for (int i = 0; i < num; i++) {
            arraySum += array[i];
        }
        return sum - arraySum;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 4 };
        TestArray obj = new TestArray();
        System.out.println(obj.findMissingNumber(array));
    }

}

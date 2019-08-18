package com.java.array;

public class SingleElementInSortedArray {

    public static void main(String[] args) {
        SingleElementInSortedArray obj = new SingleElementInSortedArray();
        int[] array = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6 };
        System.out.println(obj.doTask(array));
    }

    private Integer doTask(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] == array[mid - 1]) {
                left = mid + 1;
            }
            else {
                return array[mid];
            }
        }
        return null;
    }
}

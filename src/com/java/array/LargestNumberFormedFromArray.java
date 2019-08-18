package com.java.array;

//This solution works only if array elements are from 0 - 9
//Time complexity O(n) and Space Complexity O(1)
public class LargestNumberFormedFromArray {

    private void doTask(int[] array) {
        int[] set = new int[10];
        for (int i = 0; i < array.length; i++) {
            set[array[i]]++;
        }
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < set[i]; j++) {
                System.out.print(i);
            }
        }
    }

    public static void main(String[] args) {
        LargestNumberFormedFromArray obj = new LargestNumberFormedFromArray();
        int[] array = { 2, 4, 1, 4, 6, 2, 5 };
        obj.doTask(array);
    }

}

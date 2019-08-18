package com.java.array;

public class Test {

    private void doTask(int[] array, int k) {
        int size = array.length;
        if (k > size)
            k = k % size;
        k = size - k;
        for (int i = k; i < size + k; i++) {
            System.out.print(array[i % size] + " ");
        }
    }


    public static void main(String[] args) {
        Test obj = new Test();
        int[] array = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int k = 1;
        obj.doTask(array, k);
    }
}

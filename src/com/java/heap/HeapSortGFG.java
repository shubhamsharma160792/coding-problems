package com.java.heap;

public class HeapSortGFG {

    private int[] doTask(int[] array) {
        int size = array.length;
        for(int i=size/2-1; i>=0;i--){
            heapify(array,size,i);
        }
        for (int i = size - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        return array;
    }

    private void heapify(int[] array, int size, int pos) {
        int largest = pos;
        int l = 2 * pos + 1;
        int r = 2 * pos + 2;
        if (l < size && array[l] > array[largest])
            largest = l;
        if (r < size && array[r] > array[largest])
            largest = r;
        if (largest != pos) {
            int temp = array[largest];
            array[largest] = array[pos];
            array[pos] = temp;
            heapify(array, size, largest);
        }
    }

    public static void main(String[] args) {
        int[] array = { 10, 20, 15, 30, 40 };
        HeapSortGFG obj = new HeapSortGFG();
        int[] sortedArray = obj.doTask(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}

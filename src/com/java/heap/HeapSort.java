package com.java.heap;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        int[] array = {10,20,15,30,40};
        int[] heapArray = obj.doTask(array);
        for (int i = 1; i < heapArray.length; i++) {
            System.out.print(heapArray[i] + " ");
        }
    }

    private void adjustHeapPropertyBU(int[] heapArray, int i) {
        while (i >= 1) {
            int parent = i / 2;
            if (parent < 1) {
                return;
            }
            if (heapArray[parent] <= heapArray[i]) {
                int temp = heapArray[parent];
                heapArray[parent] = heapArray[i];
                heapArray[i] = temp;
            }
            i = i / 2;
        }
    }

    private void adjustHeapPropertyTD(int[] heapArray, int i) {
        while (i < heapArray.length) {
            int max = Math.max(heapArray[2 * i], heapArray[2 * i + 1]);
            if (max > heapArray[i]) {
                int temp = max;

            }
        }
    }

    private int[] doTask(int[] array) {
        int[] heapArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            heapArray[i + 1] = array[i];
            adjustHeapPropertyBU(heapArray, i + 1);
        }
        int val = heapArray.length - 1;
        for(int i=1;i< heapArray.length;i++){
            int temp = heapArray[i];
            heapArray[i] = heapArray[val - i];
            heapArray[val - i] = temp;
            adjustHeapPropertyTD(heapArray, i);
            val--;
        }
        return heapArray;
    }

}

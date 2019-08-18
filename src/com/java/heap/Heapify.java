package com.java.heap;

public class Heapify {

    private int   size;
    public int[] array;

    public Heapify(int[] arr) {
        super();
        this.array = arr;
        this.size = arr.length;
    }

    private int getLeftChildIndex(int pos) {
        return 2 * pos + 1;
    }

    private int getRightChildIndex(int pos) {
        return 2 * pos + 2;
    }

    private boolean isLeafNode(int pos) {
        if (pos >= this.size / 2 && pos <= this.size) {
            return true;
        }
        return false;
    }

    private void maxHeapify(int pos) {
        if (!isLeafNode(pos)) {
            int largestElementIndex = pos;
            int leftChildIndex = getLeftChildIndex(pos);
            int rightChildIndex = getRightChildIndex(pos);
            if (leftChildIndex < this.size && this.array[leftChildIndex] > this.array[pos]) {
                largestElementIndex = leftChildIndex;
            }
            if (rightChildIndex < this.size && this.array[rightChildIndex] > this.array[pos]) {
                largestElementIndex = rightChildIndex;
            }
            if (largestElementIndex != pos) {
                // Do swapping
                int temp = this.array[largestElementIndex];
                this.array[largestElementIndex] = this.array[pos];
                this.array[pos] = temp;

                // Call maxHeapify for the largestElementIndex
                maxHeapify(largestElementIndex);
            }
        }
    }

    public void constructMaxHeap() {
        int len = this.array.length;
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void printMaxHeap() {
        for (int i = 0; i < this.array.length; i++) {
            System.out.println(this.array[i]);
        }
    }

    public static void main(String[] args) {
        // int[] arr = { 10, 20, 15, 30, 40 };
        int[] arr = { 4, 10, 3, 5, 1 };
        Heapify obj = new Heapify(arr);
        obj.constructMaxHeap();
        obj.printMaxHeap();

    }

}

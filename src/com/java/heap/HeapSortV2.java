package com.java.heap;

public class HeapSortV2 {

    private int[] array;
    private int   size;

    public HeapSortV2(int[] array) {
        super();
        this.array = array;
        this.size = array.length;
    }

    public static void main(String[] args) {
        // int[] array = { 10, 20, 15, 30, 40 };
        int[] array = { 4, 10, 3, 5, 1 };

        HeapSortV2 obj = new HeapSortV2(array);
        obj.heapSort();
    }

    private void heapSort() {
        for (int i = this.size / 2; i >= 0; i--) {
            heapify(i);
        }
        for (int i = this.size - 1; i >= 0; i--) {

            // Swapping
            int temp = this.array[0];
            this.array[0] = this.array[i];
            this.array[i] = temp;
            heapify(i);
        }
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    private boolean isLeafNode(int position){
        if (position >= this.size / 2 && position <= size) {
            return true;
        }
        return false;
    }

    private void heapify(int pos) {
        if (!isLeafNode(pos)) {
            int largestElementIndex = pos;
            int leftChildIndex = getLeftChild(pos);
            int rightChildIndex = getRightChild(pos);
            if (leftChildIndex < this.size && this.array[leftChildIndex] > this.array[pos]) {
                largestElementIndex = leftChildIndex;
            }
            if (rightChildIndex < this.size && this.array[rightChildIndex] > this.array[pos]) {
                largestElementIndex = rightChildIndex;
            }
            if (largestElementIndex != pos) {
                //Swapping
                int temp = this.array[largestElementIndex];
                this.array[largestElementIndex] = this.array[pos];
                this.array[pos] = temp;
                heapify(largestElementIndex);
            }
        }
    }
}

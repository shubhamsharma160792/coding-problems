package com.java.array;

public class SearchInSortedRotatedArray {

    private Integer search(int[] array, int l, int h, int key) {
        if (l > h)
            return -1;
        int mid = (l + h) / 2;
        if (array[mid] == key)
            return mid;
        if (array[mid] >= array[l]) {
            if (key >= array[l] && key <= array[mid])
                return search(array, l, mid - 1, key);
            return search(array, mid + 1, h, key);
        }

        // If above sub-array is not sorted then this must be sorted.
        if (key > array[mid] && key <= array[h])
            return search(array, mid + 1, h, key);
        return search(array, l, mid - 1, key);
    }

    public static void main(String[] args) {
        SearchInSortedRotatedArray obj = new SearchInSortedRotatedArray();
        int[] array = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int key = 5;
        int index = obj.search(array, 0, array.length - 1, key);
        System.out.printf("Index for searched key : %d", index);
    }
}

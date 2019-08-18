package com.java.array;

public class CountElementOccurenceInSortedArray {

    public int binarySearch(int[] A, int B, boolean searchFirst) {
        int start = 0, end = A.length - 1, result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == B) {
                result = mid;
                if (searchFirst)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else if (A[mid] < B) {
                start = mid + 1;
            }
            else if (A[mid] > B) {
                end = mid - 1;
            }
        }
        return result;
    }

    public int doTask(int[] array, int B) {
        int firstOccurenceIndex = binarySearch(array, B, true);
        int lastOCcurenceIndex = binarySearch(array, B, false);
        if (firstOccurenceIndex == -1 || lastOCcurenceIndex == -1)
            return 0;
        return lastOCcurenceIndex - firstOccurenceIndex + 1;
    }

    public static void main(String[] args) {
        CountElementOccurenceInSortedArray obj = new CountElementOccurenceInSortedArray();
        int[] array = { 1, 1, 2, 3, 3, 3, 3, 3, 4, 5, 6 };
        System.out.println(obj.doTask(array, 1));
    }

}

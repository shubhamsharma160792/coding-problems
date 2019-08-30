package com.java.matrix;

public class SearchInSortedMatrix {

    private boolean search(int[][] array, int B) {
        int m = array.length;
        int n = array[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (array[i][j] == B)
                return true;
            else if (array[i][j] > B)
                j--;
            else
                i++;
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInSortedMatrix obj = new SearchInSortedMatrix();
        int[][] array = { { 1, 2, 3, 4 }, { 2, 4, 6, 8 }, { 3, 6, 7, 11 } };
        System.out.printf("Element exists: %b", obj.search(array, 7));
    }

}

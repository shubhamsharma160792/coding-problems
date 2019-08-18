package com.java.array;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveDuplicatesFromSortedArray {

    static int removeDuplicates(Integer arr[], int n) {
        if (n == 0 || n == 1)
            return n;
        int j = 0;
        for (int i = 0; i < n - 1; i++)
            if (arr[i] != arr[i + 1])
                arr[j++] = arr[i];

        arr[j++] = arr[n - 1];
        return j;
    }

    public int removeDuplicates(ArrayList<Integer> a) {
        int counter = 0, size = a.size();
        for (int i = a.size() - 1; i > 0; i--) {
            if (a.get(i - 1).equals(a.get(i))) {
                a.remove(i);
                counter++;
            }
        }
        return size - counter;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        Integer[] array = { 5000, 5000, 5000 };
        ArrayList<Integer> arraylist = new ArrayList<>();
        Collections.addAll(arraylist, array);
        System.out.println(obj.removeDuplicates(arraylist));
        System.out.println(removeDuplicates(array, 3));
    }

}

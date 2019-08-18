package com.java.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairHavingRequiredSum {

    private boolean isPairExists(int[] arr, int sum) {
        if (arr.length < 2) {
            return false;
        }
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int currentSum = arr[l] + arr[r];
            if (currentSum == sum)
                return true;
            else if (currentSum > sum)
                r = r - 1;
            else
                l = l + 1;
        }
        return false;
    }

    private boolean isPairExistsIfNotSorted(int[] arr, int sum) {
        if (arr.length < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(sum - arr[i])) {
                return true;
            }else{
                set.add(arr[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PairHavingRequiredSum obj = new PairHavingRequiredSum();
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array size");
        int size = Integer.parseInt(scan.nextLine());
        System.out.println("Enter array elements");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println("Enter required sum");
        int sum = scan.nextInt();
        if (obj.isPairExists(array, sum) || obj.isPairExistsIfNotSorted(array, sum)) {
            System.out.println("Pair exists");
        }
        else {
            System.out.println("Pair doesn't exists");
        }
    }

}

package com.java.array;

import java.util.HashSet;

//Given an array A of integers and another non negative integer k, 
//find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j
public class TwoNumDiff {

    private boolean doTask(int[] array, int diff) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : array){
            if (set.contains(val + diff) || set.contains(val - diff))
                return true;
            else
                set.add(val);
        }
        return false;
    }

    public static void main(String[] args) {
        TwoNumDiff obj = new TwoNumDiff();
        int[] array = { 1, 5, 3 };
        System.out.printf("Diff exists: %b", obj.doTask(array, 2));
    }

}

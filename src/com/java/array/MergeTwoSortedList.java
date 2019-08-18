package com.java.array;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedList {

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0, j=0;
        while(i < a.size() && j < b.size()){
            if(a.get(i) < b.get(j)){
                a.add(a.get(i));
                a.remove(i);
            }else{
                a.add(b.get(j));
                j++;
            }
        }
        while(i < a.size()){
            a.add(a.get(i));
            a.remove(i);
            i++;
        }
        while(j < b.size()){
            a.add(b.get(j));
            j++;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedList obj = new MergeTwoSortedList();
        Integer[] arrayA = { 1, 2 };
        Integer[] arrayB = { -1, 2 };
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        Collections.addAll(a, arrayA);
        Collections.addAll(b, arrayB);
        obj.merge(a, b);
        for (Integer val : a)
            System.out.print(val + " ");
    }

}

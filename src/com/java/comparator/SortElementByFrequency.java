package com.java.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortElementByFrequency {
    
    private void sortList(int array[]){
        List<Integer> arrayValues = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            int value = map.getOrDefault(i, 0);
            map.put(i, value + 1);
            arrayValues.add(i);
        }
        CustomComparator comp = new CustomComparator(map);
        Collections.sort(arrayValues, comp);
        
        for (Integer i : arrayValues) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 4, 2, 1, 5, 2, 5 };
        SortElementByFrequency obj = new SortElementByFrequency();
        obj.sortList(array);
    }

}

class CustomComparator implements Comparator<Integer> {

    private final Map<Integer, Integer> map;

    public CustomComparator(Map<Integer, Integer> map) {
        super();
        this.map = map;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        int freqCompare = this.map.get(o2).compareTo(this.map.get(o1));
        int valCompare = o1.compareTo(o2);
        if (freqCompare == 0) {
            return valCompare;
        }
        return freqCompare;
    }

}

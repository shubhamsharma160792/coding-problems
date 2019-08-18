package com.java.array;

import java.util.ArrayList;
import java.util.List;

public class MaxContiniousOnesWithFlips {

    private List<Integer> doTask(int[] array, int B) {
        List<Integer> result = new ArrayList<>();
        int l = 0, r = 0, numberOfZeroes = 0, maxWindowLength = 0;
        int start=-1,end=-1;
        while (r < array.length) {
            if (numberOfZeroes <= B) {
                if (array[r] == 0)
                    numberOfZeroes++;
                r++;
            }
            if (numberOfZeroes > B) {
                if (array[l] == 0)
                    numberOfZeroes--;
                l++;
            }
            
            //Check for max window
            if(r-l > maxWindowLength){
                maxWindowLength = r-l;
                start = l;
                end = r;
            }
        }
        for (int i = start; i < end; i++)
            result.add(i);
        return result;
    }

    public static void main(String[] args) {
        MaxContiniousOnesWithFlips obj = new MaxContiniousOnesWithFlips();
        int[] array = { 1, 1, 0, 1, 1, 0, 0, 1, 1, 1 };
        List<Integer> result = obj.doTask(array, 1);
        for (Integer r : result)
            System.out.print(r + " ");
    }

}

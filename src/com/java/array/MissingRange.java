package com.java.array;

import java.util.Arrays;
import java.util.List;

public class MissingRange {

    public static void main(String[] args) {
        MissingRange obj = new MissingRange();
        int[] array = { 0, 1, 3, 50, 75 };
        int lower = 0, upper = 99;
        obj.doTask(array, lower, upper);
    }

    private void doTask(int[] array, int lower, int upper) {
        int length = array.length;
        int endNumber = 0, startNumber=0;
        for (int i = lower; i <= upper; i++) {
            boolean flag = Arrays.asList(array).contains(i);
            if(flag){
                startNumber++;
                endNumber++;
            }
            else{
                System.out.println(startNumber + "," + endNumber);
                startNumber = i;
                endNumber = i;
            }
                
                
        }
    }

}

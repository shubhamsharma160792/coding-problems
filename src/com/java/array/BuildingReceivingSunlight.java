package com.java.array;

public class BuildingReceivingSunlight {

    private Integer doTask(int[] array) {
        int maxSoFar = Integer.MIN_VALUE, counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxSoFar <= array[i]) {
                maxSoFar = array[i];
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        BuildingReceivingSunlight obj = new BuildingReceivingSunlight();
        int[] array = { 6, 2, 8, 4, 11, 13 };
        System.out.println(obj.doTask(array));
    }

}

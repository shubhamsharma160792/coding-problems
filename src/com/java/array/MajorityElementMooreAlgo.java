package com.java.array;

public class MajorityElementMooreAlgo {

    private Integer findCandidate(int[] array) {
        int maxElement = array[0];
        int counter = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == maxElement)
                counter++;
            else
                counter--;
            if (counter == 0) {
                counter = 1;
                maxElement = array[i];
            }
        }
        return maxElement;
    }

    private boolean isCandidateMajorElement(int[] array, int candidate) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == candidate)
                counter++;
        }
        if (counter > array.length / 2)
            return true;
        return false;
    }

    private Integer doTask(int[] array) {
        int candidate = findCandidate(array);
        if (isCandidateMajorElement(array, candidate))
            return candidate;
        return -1;
    }

    public static void main(String[] args) {
        MajorityElementMooreAlgo obj = new MajorityElementMooreAlgo();
        int[] array = { 5, 3, 1, 1, 3, 3, 3, 1, 3 };
        System.out.println(obj.doTask(array));
    }

}

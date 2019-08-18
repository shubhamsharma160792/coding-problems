package com.java.array;

import java.util.Arrays;

public class LargestContinuousSubArrayWithZeroSum {

    public static class Pair<T, U> {
        public T first;
        public U second;

        public Pair(T t, U u) {
            this.first = t;
            this.second = u;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public U getSecond() {
            return second;
        }

        public void setSecond(U second) {
            this.second = second;
        }
    }

    public int[] lszero(int[] A) {
        int i = 0, j = 0, sumSoFar = 0, maxSize = 0;
        Pair<Integer, Integer> pair = new Pair<>(-1, -1);
        while (i < A.length) {
            sumSoFar += A[i];
            if (sumSoFar == 0 && i - j > maxSize) {
                pair.setFirst(j);
                pair.setSecond(i);
                maxSize = i - j;
            }
            else if (sumSoFar > 0) {
                sumSoFar = sumSoFar - A[i] - A[j];
                j++;
            }
            else {
                i++;
            }
        }
        if (pair.getFirst() == -1 || pair.getSecond() == -1) {
            return null;
        }
        return subArray(A, pair.getFirst(), pair.getSecond());
    }

    public static int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end);
    }

    public static void main(String[] args) {
        LargestContinuousSubArrayWithZeroSum obj = new LargestContinuousSubArrayWithZeroSum();
        int[] array = { 1, 2, -2, 4, -4 };
        int[] result = obj.lszero(array);
    }

}

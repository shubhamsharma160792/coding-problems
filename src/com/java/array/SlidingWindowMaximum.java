package com.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMaximum {

    private int getMaxElement(final List<Integer> A) {
        int maxSoFar = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxSoFar)
                maxSoFar = A.get(i);
        }
        return maxSoFar;
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if (B > A.size()) {
            result.add(getMaxElement(A));
            return result;
        }
        if (B == 1) {
            return new ArrayList<>(A);
        }
        int maxSoFar = A.get(0);
        int secondMax = A.get(1);
        for (int j = 2; j < B; j++) {
            if (A.get(j) >= maxSoFar) {
                secondMax = maxSoFar;
                maxSoFar = A.get(j);
            }
        }
        result.add(maxSoFar);
        for (int j = B; j < A.size(); j++) {
            if (A.get(j) >= maxSoFar)
                maxSoFar = A.get(j);
            else if (A.get(j) > secondMax)
                secondMax = A.get(j);
            if (A.get(j - B) == maxSoFar && A.get(j) != maxSoFar)
                result.add(secondMax);
            else
                result.add(maxSoFar);
        }
        return result;
    }
    
    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        int B = 2;
        for (Integer val : obj.slidingMaximum(A, B)) {
            System.out.print(val + " ");
        }
    }
}

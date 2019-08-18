package com.java.array;

public class ContiniousSubarrayWithRequiredSum {

    public class Pair<T, U> {
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

    private Pair<Integer,Integer> doTask(int[] arr, int requiredSum) {
        Pair<Integer, Integer> result = new Pair<>(-1, -1);
        int i = 0, j = 0, sumSoFar = 0;

        while (i < arr.length) {
            sumSoFar = sumSoFar + arr[i];
            if (sumSoFar == requiredSum) {
                result.setFirst(j + 1);
                result.setSecond(i + 1);
                break;
            }
            else if (sumSoFar > requiredSum) {
                sumSoFar = sumSoFar - arr[i] - arr[j];
                j++;
            }
            else {
                i++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ContiniousSubarrayWithRequiredSum obj = new ContiniousSubarrayWithRequiredSum();
        int[] arr = { 1, 2, 3, 7, 5 };
        Pair<Integer, Integer> result = obj.doTask(arr, 12);
        System.out.printf("sum found start index: %d and end index %d", result.getFirst(), result.getSecond());
    }

}

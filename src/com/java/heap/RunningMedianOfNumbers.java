package com.java.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedianOfNumbers {

    private double[] doTask(int[] array) {
        double[] median = new double[array.length];

        // Max Heap
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return -1*o1.compareTo(o2);
            }
        });
        
        // Min Heap
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        for(int i=0; i< array.length; i++){
            addNumber(array[i], lowers, highers);
            rebalance(lowers, highers);
            median[i] = getMedian(lowers, highers);
        }
        return median;
    }

    private double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() == smallerHeap.size())
            return (double) (biggerHeap.peek() + smallerHeap.peek()) / 2;
        else
            return biggerHeap.peek();
    }

    private void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        if (biggerHeap.size() - smallerHeap.size() > 1)
            smallerHeap.add(biggerHeap.poll());
    }

    private void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.isEmpty() || number < lowers.peek())
            lowers.add(number);
        else
            highers.add(number);
    }

    public static void main(String[] args) {
        RunningMedianOfNumbers obj = new RunningMedianOfNumbers();
        int[] array = { 59, 64, 10, 39 };
        double[] answer = obj.doTask(array);
        for (double i : answer) {
            System.out.println("Mean: " + i);
        }
    }

}

package com.java.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveElementFromArray {

    public int removeElementV2(ArrayList<Integer> a, int b) {
        int counter = 0, size = a.size();
        Queue<Integer> q = new LinkedList<>(a);
        for (int i = 0; i < size; i++) {
            if (b == q.peek()) {
                counter++;
            }
            else {
                q.add(q.peek());
            }
            q.poll();
        }
        return size - counter;
    }

    public int removeElement(ArrayList<Integer> a, int b) {
        int counter = 0, size = a.size();
        for (int i = 0; i < size; i++) {
            if (b == a.get(0)) {
                counter++;
            }
            else {
                a.add(a.get(0));
            }
            a.remove(0);
        }
        return size - counter;
    }

    public static void main(String[] args) {
        RemoveElementFromArray obj = new RemoveElementFromArray();
        Integer[] arrayA = { 2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0 };
        ArrayList<Integer> a = new ArrayList<Integer>();
        Collections.addAll(a, arrayA);
        System.out.println(obj.removeElement(a, 2));
    }

}

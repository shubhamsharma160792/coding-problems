package com.java.string;

import java.util.ArrayList;
import java.util.Arrays;

public class StringOHolics {

    private static String leftrotate(String str, int d) {
        return str.substring(d) + str.substring(0, d);
    }

    public int doTask(ArrayList<String> A) {
        boolean flag;
        int time = 0;
        ArrayList<String> B = new ArrayList<>();
        for (String str : A) {
            B.add(str);
        }
        while (true) {
            flag = true;
            int index = 0;
            for (String str : B) {
                String rString = leftrotate(str, time % str.length());
                B.set(index, rString);
                flag = flag && rString.equals(A.get(index));
                index++;
            }
            if (flag && time != 0)
                return time - 1;
            time++;
        }
    }

    public static void main(String[] args) {
        StringOHolics obj = new StringOHolics();
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "ababa", "aba"));
        System.out.println(obj.doTask(list));
    }

}

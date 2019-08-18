package com.java.array;

import java.util.Arrays;
import java.util.Comparator;

public class Test2 {

    private String doTask(int[] array) {
        String[] strArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            strArray[i] = String.valueOf(array[i]);
        }
        Arrays.sort(strArray, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder strBuilder = new StringBuilder();
        for (String str : strArray) {
            strBuilder.append(str);
        }
        while (strBuilder.charAt(0) == '0' && strBuilder.length() > 0)
            strBuilder.deleteCharAt(0);
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        Test2 obj = new Test2();
        int[] array = { 54, 546, 548, 60 };
        System.out.println(obj.doTask(array));
    }

}

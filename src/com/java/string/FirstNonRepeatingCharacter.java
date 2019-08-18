package com.java.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public Character doTaskOptimised(String input) {
        try {
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (map.containsKey(c)) {
                    Integer oldValue = map.get(c);
                    map.put(c, oldValue + 1);
                }
                else {
                    map.put(c, 1);
                }
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }

    // Iterations. Time: 2*O(n) and Space O(n)
    public Character doTask(String input) {
        try {
            int counter = 0;
            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                counter = map.getOrDefault(c, 0);
                map.put(c, counter + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String input = "GeeksForGeeks";
        FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();
        System.out.println(obj.doTask(input));
    }
}



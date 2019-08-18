package com.java.string;

public class CountAndSay {

    private String doTask(int n) {
        if (n == 0)
            return null;
        String result = "1";
        int i = 1;
        while (i < n) {
            StringBuilder strBuilder = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                }
                else {
                    strBuilder.append(count);
                    strBuilder.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            strBuilder.append(count);
            strBuilder.append(result.charAt(result.length() - 1));
            result = strBuilder.toString();
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.doTask(5));
    }

}

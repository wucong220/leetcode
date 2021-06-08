package com.wu;

import java.util.Arrays;
import java.util.Comparator;

public class CN179 {
    class Solution {
        public String largestNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strs[i] = "" + nums[i];
            }
            String a = Arrays.stream(strs).sorted((o1, o2) -> compare(o1, o2)).reduce((a1, b) -> a1 + b).get();
            while(a.startsWith("0")&&a.length()>1){
                a=a.substring(1);
            }
            return a;
        }

        public int compare(String o1, String o2) {
            if (o1.length() == o2.length()) return -o1.compareTo(o2);
            else {
                String l;
                String s;
                if (o1.length() > o2.length()) {
                    l = o1;
                    s = o2;
                    if (l.startsWith(s))
                        return compare(l.substring(s.length()),s);
                    else return -o1.compareTo(o2);
                } else {
                    l = o2;
                    s = o1;
                    if (l.startsWith(s))
                        return compare(s,l.substring(s.length()));
                    else return -o1.compareTo(o2);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println( new CN179().new Solution().compare("3","30"));
    }
}

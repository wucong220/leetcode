package com.wu;

/**
 * @author wuc006
 * @date 2020/4/21 16:15
 */
public class P1415 {
    class Solution {
        public String getHappyString(int n, int k) {
            return getHappyString1(n - 1, k - 1);
        }

        public String getHappyString1(int n, int k) {
            if (n == 0) {
                if (k < 3)
                    return String.valueOf((char) ('a' + k));
                else
                    return "";
            }
            int upK = k / 2;
            int offset = k % 2;
            String upString = getHappyString1(n - 1, upK);
            if(upString.length()==0)return upString;
            char lastChar = upString.charAt(upString.length() - 1);
            switch (lastChar) {
                case 'a':
                    return upString + (char) ('b' + offset);
                case 'b':
                    return upString + (char) ('a' + 2 * offset);
                case 'c':
                    return upString + (char) ('a' + offset);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        String happyString = new P1415().new Solution().getHappyString(10, 100);
        System.out.println(happyString);
    }
}

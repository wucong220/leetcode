package com.wu;

/**
 * @author wuc006
 * @date 2021/4/26 17:11
 */
public class Offer43 {
    class Solution {
        public int countDigitOne(int n) {
            String s = String.valueOf(n);
            int ret = 0;
            if (n == 0) return 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int left = 1;
                if (i > 0) {
                    left = Integer.parseInt(s.substring(0, i)) + 1;
                    if (c == '0') {
                        left--;
                        c='9';
                    }
                }
                int right = 1;
                if (i < s.length() - 1) {
                    if (c > '1') right = (int) (Math.pow(10, s.length() - i - 1));
                    else {
                        if(left>1) {
                            left--;
                            right = (int) (Math.pow(10, s.length() - i - 1));
                            ret+=Integer.parseInt(s.substring(i + 1)) + 1;
                        }
                        else{
                            right = Integer.parseInt(s.substring(i + 1)) + 1;
                        }
                    }
                }
                ret += left * right;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(111);
    }
}

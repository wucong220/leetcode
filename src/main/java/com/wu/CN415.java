package com.wu;

/**
 * @author wuc006
 * @date 2021/4/22 16:42
 */
public class CN415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            int residue = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
                char c1 = i >= 0 ? num1.charAt(i) : '0';
                char c2 = j >= 0 ? num2.charAt(j) : '0';
                int i1 = c1 - '0';
                int i2 = c2 - '0';
                int curr = (i1 + i2 + residue) % 10;
                residue = (i1 + i2 + residue) / 10;
                sb.append(curr);
            }
            if (residue > 0) sb.append(residue);
            return sb.reverse().toString();
        }

        public String subtractStrings(String num1, String num2) {
            boolean signFlag = true;
            if (num1.length() == num2.length()) {
                signFlag = num1.compareTo(num2) > 0;
            } else {
                signFlag = num1.length() > num2.length();
            }

            if (!signFlag) {
                String temp = num1;
                num1 = num2;
                num2 = temp;
            }

            int borrow = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
                char c1 = i >= 0 ? num1.charAt(i) : '0';
                char c2 = j >= 0 ? num2.charAt(j) : '0';
                int i1 = c1 - '0';
                int i2 = c2 - '0';
                i1 = i1 + borrow;
                if (i1 < i2) {
                    i1 = i1 + 10;
                    borrow = -1;
                }
                sb.append(i1 - i2);
            }
            StringBuilder reverse = sb.reverse();
            int i = 0;
            for (; i < reverse.length() - 1; i++) {
                if (reverse.charAt(i) != 0) {
                    break;
                }
            }
            return !signFlag ? "-" + reverse.substring(i) : reverse.substring(i);
        }

        public String addStrings36(String num1, String num2) {
            int residue = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
                char c1 = i >= 0 ? num1.charAt(i) : '0';
                char c2 = j >= 0 ? num2.charAt(j) : '0';
                int i1 = Character.isDigit(c1)?c1 - '0':c1-'a'+10;
                int i2 = Character.isDigit(c2)?c2 - '0':c2-'a'+10;
                int curr = (i1 + i2 + residue) % 36;
                residue = (i1 + i2 + residue) / 36;
                sb.append((char)(curr<10?(curr + '0'):(curr-10+'a')));
            }
            if (residue > 0) sb.append(residue);
            return sb.reverse().toString();
        }
    }



    public static void main(String[] args) {
        System.out.println(new CN415().new Solution().subtractStrings("1","123"));
        System.out.println(new CN415().new Solution().addStrings36("1rgfwrez","a"));
    }
}

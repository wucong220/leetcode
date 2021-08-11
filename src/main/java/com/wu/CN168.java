package com.wu;

/**
 * @author wuc006
 * @date 2021/6/29 9:57
 */
public class CN168 {
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while(columnNumber>0){
                int i = columnNumber % 26;
                columnNumber=columnNumber/26;
                if(i==0){
                    sb.append("Z");
                    columnNumber--;
                }
                else sb.append((char)('A'+i-1));

            }
            return sb.reverse().toString();
        }
    }

    public static void main(String[] args) {
        RunUtil.run(701);
    }
}

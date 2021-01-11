package com.wu;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author wuc006
 * @date 2020/9/1 17:44
 */
public class CN8 {
    class Solution {
        public int myAtoi(String str) {
            str = str.trim();
            int flag = 1;
            if(str.charAt(0)=='+'||str.charAt(0)=='-'){
                if(str.charAt(0)=='-'){
                    flag = -1;
                }
                str = str.substring(1);
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    sb.append(str.charAt(i));
                }
                else{
                    break;
                }
            }
            BigInteger bigInteger = new BigInteger(sb.toString());
            if (bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0){
                return Integer.MAX_VALUE;
            }
            if (bigInteger.compareTo(BigInteger.valueOf(Integer.MIN_VALUE))<0){
                return Integer.MIN_VALUE;
            }
            return bigInteger.intValueExact();
        }
    }

    public static void main(String[] args) {

    }
}

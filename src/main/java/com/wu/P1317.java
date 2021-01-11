package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/1/19 9:16
 */
public class P1317 {
    class Solution {
        public int[] getNoZeroIntegers(int n) {
            for(int i=1;i<=n/2;i++){
                if(isZeroInteger(i)&&isZeroInteger(n-i)){
                    return new int[]{i,n-i};
                }
            }
            return null;
        }

        private boolean isZeroInteger(int n){
            while(n!=0) {
                int digit = n % 10;
                if(digit==0)return false;
                n=n/10;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString( (int[])RunUtil.run(10000)));
    }

}

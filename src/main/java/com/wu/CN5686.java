package com.wu;

/**
 * @author wuc006
 * @date 2021/2/22 11:27
 */
public class CN5686 {
    class Solution {
        public int[] minOperations(String boxes) {
            int[] ret = new int[boxes.length()];
            for(int i=0;i<boxes.length();i++){
                for(int j=0;j<boxes.length();j++){
                    if(boxes.charAt(j)=='1'){
                        ret[i]+=Math.abs(i-j);
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {

    }
}

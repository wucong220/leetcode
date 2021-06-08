package com.wu;

import java.util.concurrent.ThreadPoolExecutor;

public class CN5737 {
    class Solution {
        public int getXORSum(int[] arr1, int[] arr2) {
            int ret = 0;
            for(int i=0;i<arr1.length;i++){
                for(int j=0;j<arr2.length;j++){
                    ret^=arr1[i]&arr2[i];
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2,3]"),RunUtil.toArray("[6,5]"));
    }
}

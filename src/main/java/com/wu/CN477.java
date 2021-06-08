package com.wu;

/**
 * @author wuc006
 * @date 2021/5/28 11:34
 */
public class CN477 {
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int[] oneBitCount = new int[32];
            int[] zeroBitCount = new int[32];
            int ret = 0;
            for(int i=0;i<nums.length;i++){
                for(int j=0;j<32;j++){
                    int currBit = (nums[i] >> j) & 1;
                    if(currBit==0){
                        ret+=oneBitCount[j];
                        zeroBitCount[j]++;
                    }
                    else{
                        ret+=zeroBitCount[j];
                        oneBitCount[j]++;
                    }
                }
            }
            return ret;
        }
    }
}

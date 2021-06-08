package com.wu;

/**
 * @author wuc006
 * @date 2021/2/23 9:29
 */
public class CN1052 {
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            int ret = 0;
            for(int i=0;i<grumpy.length;i++){
                if(grumpy[i]==0){
                    ret+=customers[i];
                }
            }
            int left = 0;
            int max = 0;
            for(int i=0;i<grumpy.length;i++){
                if(i-left+1>X){
                    if(grumpy[left]==1)ret-=customers[left];
                    left++;
                }

                if(grumpy[i]==1){
                    ret+=customers[i];
                }
                max = Math.max(ret,max);
            }

            return max;
        }
    }
}

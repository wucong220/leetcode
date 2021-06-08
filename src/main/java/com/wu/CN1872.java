package com.wu;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

/**
 * @author wuc006
 * @date 2021/5/25 17:11
 */
public class CN1872 {
    class Solution {
        public int stoneGameVIII(int[] stones) {
            int[] d = new int[stones.length];
            int[] preSum = new int[stones.length];
            for(int i=0;i<stones.length;i++){
                preSum[i] = (i==0?0:preSum[i-1])+stones[i];
            }
            for(int i=d.length-1;i>=0;i--){
                if(i==d.length-1){
                    d[i] = preSum[i-1]+stones[i];
                }
                else if(i==0){
                    d[i] = Integer.MIN_VALUE;
                    for(int j=1;j<=1;j++){
                        d[i] = Math.max(preSum[j]-(j==d.length-1?0:d[j+1]),(j==d.length-1?Integer.MIN_VALUE:d[j+1]));
                    }
                }
                else{
                    d[i] = Math.max(preSum[i]-(i==d.length-1?0:d[i+1]),d[i+1]);
                }
            }

            return d[0];
        }

        private int stones(int[] stones ,int start ,int score) {
            if(start==stones.length)return 0;
            int ret = Integer.MIN_VALUE;
            int sum = 0;
            for(int i=start;i<stones.length;i++){
                sum += stones[i];
                ret = Math.max(sum+score-stones(stones,i+1,sum+score),ret);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[-1,2,-3,4,-5]"));
    }
}

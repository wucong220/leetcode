package com.wu;

/**
 * @author wuc006
 * @date 2021/2/6 11:12
 */
public class CN1423 {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int[] preSum = new int[cardPoints.length];
            for(int i=0;i<cardPoints.length;i++){
                preSum[i] = (i>0?preSum[i-1]:0)+cardPoints[i];
            }
            int max = 0;
            for(int i=0;i<=k;i++){
                max = Math.max((i>0?preSum[i-1]:0)+preSum[cardPoints.length-1]-preSum[cardPoints.length-(k-i+1)],max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2,3,4,5,6,1]"),3);
    }
}

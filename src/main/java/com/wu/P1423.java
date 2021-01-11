package com.wu;

/**
 * @author wuc006
 * @date 2020/4/28 16:57
 */
public class P1423 {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int[] preSum = new int[cardPoints.length];
            int[] sufSum = new int[cardPoints.length];
            for(int i=0;i<cardPoints.length;i++){
                preSum[i] = (i==0?0:preSum[i-1])+cardPoints[i];
            }
            for(int i=cardPoints.length-1;i>=0;i--){
                sufSum[i]  = ((i==cardPoints.length-1)?0:sufSum[i+1])+cardPoints[i];
            }
            int max = 0;
            k = Math.min(k,cardPoints.length);
            for(int i=0,j=k;i<=k;i++,j--){
                //i是左边拿的牌数，j是右边拿的牌数
                int preCard = i>0?preSum[i-1]:0;
                int sufCard = j>0?sufSum[cardPoints.length-j]:0;
                max = Math.max(preCard+sufCard,max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] cardPoints = {11,49,100,20,86,29,72};
        int k = 4;
        RunUtil.run(cardPoints, k);
    }
}

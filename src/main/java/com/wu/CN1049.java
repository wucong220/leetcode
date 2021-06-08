package com.wu;

public class CN1049 {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            return lastStoneWeightIII(stones,0);
        }

        public int lastStoneWeightIII(int[] stones,int used){
            int min = Integer.MAX_VALUE;
            if(Integer.bitCount(used)==stones.length-1) {
                return stones[Integer.numberOfTrailingZeros(~used)];
            }
            for(int i=0;i<stones.length;i++){
                if(((used>>i)&1)==0){
                    used = used|(1<<i);
                    for(int j=i+1;j<stones.length;j++){
                        if(((used>>j)&1)==0){
                            int temp = stones[j];
                            stones[j] = Math.abs(stones[j]-stones[i]);
                            if(stones[j]==0)used = used|(1<<j);
                            min = Math.min(lastStoneWeightIII(stones,used),min);
                            used = used&(~(1<<j));
                            stones[j] = temp;
                        }
                    }
                    used = used&(~(1<<i));
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,1,2,3,5,8,13,21,34,55,89,14,23,37,61,98]"));
    }
}

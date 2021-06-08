package com.wu;

import java.util.List;

/**
 * @author wuc006
 * @date 2021/2/28 13:41
 */
public class CN5690 {

    class Solution {
        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            int ret = Integer.MAX_VALUE;
            for(int i=0;i<baseCosts.length;i++){
                int count = closestCost(toppingCosts,target-baseCosts[i])+baseCosts[i];
                if(Math.abs(target-count)<Math.abs(ret-target)){
                    ret = count;
                }
                else if(Math.abs(target-count)==Math.abs(ret-target)){
                    if(count<ret)ret =count;
                }
            }
            return ret;
        }

        public int closestCost(int[] toppingCosts, int target) {
            int ret = 0;
            for(int i=0;i<Math.pow(2,toppingCosts.length);i++){
                for(int j=0;j<Math.pow(2,toppingCosts.length);j++) {
                    int count=0;
                    for (int k = 0; k < toppingCosts.length; k++) {
                        if(((1<<k)&i)!=0){
                            count+=toppingCosts[k];
                        }
                        if(((1<<k)&j)!=0){
                            count+=toppingCosts[k];
                        }
                    }
                    if(Math.abs(target-count)<Math.abs(ret-target)){
                        ret = count;
                    }
                    else if(Math.abs(target-count)==Math.abs(ret-target)){
                        if(count<ret)ret =count;
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[3,10]"),RunUtil.toArray("[2,5]"),9);
    }
}

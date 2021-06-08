package com.wu;

/**
 * @author wuc006
 * @date 2021/2/22 11:30
 */
public class CN5687 {
    class Solution {
        public int maximumScore(int[] nums, int[] multipliers) {
            long[] d = new long[nums.length];
            for(int mi=multipliers.length-1;mi>=0;mi--) {
                int len = nums.length-mi;
                for (int i = 0,j=i+len-1; j< nums.length; i++,j++) {
                    if(len==1){
                        d[i] = nums[i]*multipliers[mi];
                    }
                    else {
                        d[i] = Math.max(d[i+1]+nums[i]*multipliers[mi],d[i]+nums[j]*multipliers[mi]);
                    }
                }
            }

            return (int)d[0];
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[-941,10,299,995,-346,542,-316,-879]"),RunUtil.toArray("[-93,-818,-760,-584]"));
        System.out.println(-879*-93+-941*-818+-316*-760+-584*10);
        System.out.println(-316*-760+-584*10);
    }
}

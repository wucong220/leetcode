package com.wu;

public class CN213 {
    class Solution {
        public int rob(int[] nums) {
            if(nums.length==1)return nums[0];
            if(nums.length==2)return Math.max(nums[0],nums[1]);
            int[][] d1 = new int[nums.length][nums.length];
            int[][] d2 = new int[nums.length][nums.length];
            int[][] d3 = new int[nums.length][nums.length];
            int[][] d4 = new int[nums.length][nums.length];

            for(int i=1;i<nums.length-1;i++){
                for(int j=1;j+i-1<nums.length-1;j++){
                    if(i==1){
                        d1[j][j+i-1]=nums[j];
                        d2[j][j+i-1]=0;
                        d3[j][j+i-1]=0;
                        d4[j][j+i-1]=0;
                    }
                    else if(i==2){
                        d1[j][j+i-1]=0;
                        d2[j][j+i-1]=0;
                        d3[j][j+i-1]=nums[j];
                        d4[j][j+i-1]=nums[j+i-1];
                    }
                    else{
                        d1[j][j+i-1]=d2[j+1][j+i-2]+nums[j]+nums[j+i-1];//--
                        d2[j][j+i-1]=d1[j+1][j+i-2];//++
                        d2[j][j+i-1]=Math.max(d2[j+1][j+i-2],d2[j][j+i-1]);//--
                        d2[j][j+i-1]=Math.max(d3[j+1][j+i-2],d2[j][j+i-1]);//+-
                        d2[j][j+i-1]=Math.max(d4[j+1][j+i-2],d2[j][j+i-1]);//-+
                        d3[j][j+i-1]=d4[j+1][j+i-2]+nums[j];//-+
                        d3[j][j+i-1]=Math.max(d2[j+1][j+i-2]+nums[j],d3[j][j+i-1]);//--
                        d4[j][j+i-1]=d3[j+1][j+i-2]+nums[j+i-1];
                        d4[j][j+i-1]=Math.max(d2[j+1][j+i-2]+nums[j+i-1],d4[j][j+i-1]);
                    }
                }
            }
            int ret = 0;
            ret = Math.max(ret,d1[1][nums.length-2]);
            ret = Math.max(ret,d2[1][nums.length-2]+nums[0]);
            ret = Math.max(ret,d2[1][nums.length-2]+nums[nums.length-1]);
            ret = Math.max(ret,d3[1][nums.length-2]+nums[nums.length-1]);
            ret = Math.max(ret,d4[1][nums.length-2]+nums[0]);
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[4,1,2,7,5,3,1]"));
    }
}

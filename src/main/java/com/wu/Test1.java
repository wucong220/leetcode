package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/7/20 17:01
 */
public class Test1 {
    class Solution {


        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<nums.length;i++){
                set.add(nums[i]);
            }
            int max = 0;
            for (int i=0;i<nums.length;i++){
                if(set.contains(nums[i]-1))continue;
                else{
                    int ctr = 1;
                    int curr = nums[i];
                    while(set.contains(curr+1)){
                        curr = curr+1;
                        ctr++;
                    }
                    max = Math.max(max,ctr);
                }
            }
            return max;
        }
    }

    static double halfUp(double a){
        double p5ctr = Math.floor(a / 0.5);
        return p5ctr %2==0?p5ctr*0.5:(p5ctr+1)*0.5;
    }
    public static void main(String[] args) {
        double v = halfUp(5.49);
        System.out.println(v);
    }
}

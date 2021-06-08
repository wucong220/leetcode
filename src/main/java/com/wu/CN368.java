package com.wu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CN368 {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);
            int[] d = new int[nums.length];
            int[] pre = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                d[i]=1;
                pre[i] = -1;
                for(int j=0;j<i;j++){
                    if(nums[i]%nums[j]==0) {
                        if(d[i]<d[j]+1){
                            pre[i] = j;
                            d[i] = d[j]+1;
                        }
                    }
                }
            }
            List<Integer> list = new ArrayList<>();
            int max=-1;
            int index = -1;
            for(int i=0;i<d.length;i++){
                if(d[i]>max){
                    max = d[i];
                    index = i;
                }
            }
            int temp = index;
            while(temp!=-1) {
                list.add(nums[temp]);
                temp = pre[temp];
            }
            Collections.reverse(list);
            return list;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2,3]"));
    }
}

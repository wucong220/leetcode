package com.wu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/9/18 17:40
 */
public class CN47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            return new ArrayList<>(new HashSet<>(permuteUnique(nums,0)));
        }

        public List<List<Integer>> permuteUnique(int[] nums,int i) {
            List<List<Integer>> ret = new ArrayList<>();
            if(i==nums.length-1){
                ret.add(Arrays.asList(nums[i]));
                return ret;
            }
            List<List<Integer>> lists = permuteUnique(nums, i + 1);
            for (List<Integer> list : lists) {
                for(int j=0;j<=list.size();j++) {
                    List<Integer> temp = new ArrayList<>(list.size() + 1);
                    temp.addAll(list.subList(0,j));
                    temp.add(nums[i]);
                    temp.addAll(list.subList(j,list.size()));
                    ret.add(temp);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new CN47().new Solution().permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }
}

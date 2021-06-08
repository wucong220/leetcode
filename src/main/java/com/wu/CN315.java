package com.wu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2021/5/12 17:38
 */
public class CN315 {
    class Solution {
        int[] bitTree;

        void update(int x,int val){
            while(x<bitTree.length){
                bitTree[x]+=val;
                x+=Integer.lowestOneBit(x);
            }
        }

        int query(int x){
            int ret=0;
            while(x>0){
                ret += bitTree[x];
                x-=Integer.lowestOneBit(x);
            }
            return ret;
        }

        public List<Integer> countSmaller(int[] nums) {
            TreeSet<Integer> set = new TreeSet<>();
            Arrays.stream(nums).forEach(set::add);
            Map<Integer,Integer> map = new HashMap<>();
            int index=1;
            for (Integer n : set) {
                map.put(n,index++);
            }
            bitTree = new int[set.size()+1];

            int[] count = new int[nums.length];
            for(int i=nums.length-1;i>=0;i--){
                count[i] = query(map.get(nums[i])-1);
                update(map.get(nums[i]),1);
            }
            List<Integer> list = new ArrayList<>();
            Arrays.stream(count).forEach(list::add);
            return list;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[2,0,1]"));
    }
}

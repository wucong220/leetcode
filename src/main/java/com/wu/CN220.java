package com.wu;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author wuc006
 * @date 2021/4/17 15:59
 */
public class CN220 {
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<int[]> set = new TreeSet<>(Comparator.comparingInt(a -> ((int[])a)[0]).thenComparingInt(a->((int[])a)[1]));
            for(int i=0;i<nums.length;i++){
                if(set.isEmpty())set.add(new int[]{nums[i],i});
                else {
                    int[] ceiling = set.ceiling(new int[]{nums[i],i});
                    long temp1,temp2;
                    if (ceiling!=null&&Math.abs((temp1=ceiling[0]) - (temp2=nums[i])) <= t) {
                        return true;
                    }
                    int[] floor = set.floor(new int[]{nums[i],i});
                    if (floor!=null&&Math.abs((temp1=floor[0]) - (temp2=nums[i])) <= t) {
                        return true;
                    }
                    if(i>=k){
                        set.remove(new int[]{nums[i-k],i-k});
                    }
                    set.add(new int[]{nums[i],i});
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2,5,6,7,2,4]"),4,0);
    }
}

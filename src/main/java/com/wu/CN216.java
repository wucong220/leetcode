package com.wu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/9/11 15:00
 */
public class CN216 {
    class Solution {
        public List<List<Integer>> combinationSum3(int target, int k) {
            int[] c = new int[9];
            for(int i=0;i<9;i++){
                c[i]=i+1;
            }
            return combinationSum2(c,target,k);
        }
        public List<List<Integer>> combinationSum2(int[] candidates, int target,int k) {
            List<List<Integer>> ret = combinationSum(candidates,target,0,k);
            ret.forEach(a-> Collections.sort(a));
            return new ArrayList<>(new HashSet<>(ret));
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target,int j,int k) {
            List<List<Integer>> ret = new ArrayList<>();
            if(target<=0){
                if(target==0&&k==0){
                    ret.add(new ArrayList<>());
                }
                return ret;
            }
            if(j>=candidates.length||k==0){
                return ret;
            }
            for(int i=0;i<2&&i*candidates[j]<=target;i++){
                List<List<Integer>> temp = combinationSum(candidates,target-i*candidates[j],j+1,k-i);
                if(temp!=null){
                    for(List<Integer> t:temp){
                        List<Integer> a = new ArrayList<>();
                        for(int l=0;l<i;l++){
                            a.add(candidates[j]);
                        }
                        a.addAll(t);
                        ret.add(a);
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        new CN216().new Solution().combinationSum3(7,3);
    }
}

package com.wu;

import java.util.*;

public class CN992 {
    class Solution {
        int count=0;
        Set<Integer> mem = null;
        public int subarraysWithKDistinct(int[] A, int K) {
            mem = new HashSet<>();
            Map<Integer,Integer> map = new HashMap<>();
            map.put(A[0],1);
            subarraysWithKDistinct(map,A,K,0,0);
            return count;
        }

        public void subarraysWithKDistinct(Map<Integer,Integer> map,int[] A, int K,int left, int right) {
            if(left>right||right>A.length-1)return;
            if(mem.contains(left*20000+right))return;
            mem.add(left*20000+right);
            if(map.keySet().size()==K){
                count++;
                if(left<right){
                    map.merge(A[left],-1, (a,b)->a+b==0?null:a+b);
                    subarraysWithKDistinct(map,A,K,left+1,right);
                    map.merge(A[left],1, (a,b)->a+b==0?null:a+b);
                }
                if(right<A.length-1){
                    map.merge(A[right+1],1, (a,b)->a+b==0?null:a+b);
                    subarraysWithKDistinct(map,A,K,left,right+1);
                    map.merge(A[right+1],-1, (a,b)->a+b==0?null:a+b);
                }
            }
            else if(map.keySet().size()<K){
                if(right<A.length-1) {
                    map.merge(A[right + 1], 1, (a, b) -> a + b == 0 ? null : a + b);
                    subarraysWithKDistinct(map, A, K, left, right + 1);
                    map.merge(A[right + 1], -1, (a, b) -> a + b == 0 ? null : a + b);
                }
            }
            else{
                if(left<right) {
                    map.merge(A[left], -1, (a, b) -> a + b == 0 ? null : a + b);
                    subarraysWithKDistinct(map, A, K, left + 1, right);
                    map.merge(A[left], 1, (a, b) -> a + b == 0 ? null : a + b);
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2,1,2,3]"),2);
    }
}

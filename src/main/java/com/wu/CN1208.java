package com.wu;

/**
 * @author wuc006
 * @date 2021/2/5 14:05
 */
public class CN1208 {
    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int[] cost = new int[s.length()];
            for(int i=0;i<s.length();i++){
                cost[i] = Math.abs(s.charAt(i)-t.charAt(i));
            }
            int totalCost = 0;
            int maxLength = 0;
            for(int l=0,r=0;r<s.length();){
                if(cost[r]+totalCost<=maxCost){
                    totalCost = totalCost+cost[r];
                    r++;
                }
                else{
                    while(l<=r&&cost[r]+totalCost>maxCost){
                        if(r-l>0)
                        totalCost-=cost[l];
                        l++;
                    }
                    r=Math.max(l,r);
                }
                maxLength = Math.max(r-l,maxLength);
            }
            return maxLength;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("abcd","cdef",1);
    }
}

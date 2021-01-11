package com.wu;

/**
 * @author wuc006
 * @date 2021/1/5 15:35
 */
public class P1712 {
    class Solution {
        int mod = 1000_000_007;

        public int waysToSplit(int[] nums) {
            int ret = 0;
            int[] prefix = new int[nums.length];
            for (int i = 0; i < prefix.length; i++) {
                prefix[i] = (i > 0 ? prefix[i - 1] : 0) + nums[i];
            }
            for (int i = 0; i < prefix.length-2; i++) {
                int left = biSearch1(prefix, i , prefix.length-1);
                int right = biSearch2(prefix, i , prefix.length-1);
                if(right-left>0) {
                    ret += (right - left) % mod;
                    ret %= mod;
                }
            }
            return ret;
        }


        private int biSearch1(int[] prefix, int left, int right) {
            int l = left+1;
            int r = right;
            while (l < r) {
                int m = l + (r - l) / 2;
                if(prefix[m]-prefix[left]>=prefix[left]){
                    r=m;
                }
                else{
                    l = m+1;
                }
            }
            return l;
        }

        private int biSearch2(int[] prefix, int left, int right) {
            int l = left+1;
            int r = right;
            while (l < r) {
                int m = l + (r - l) / 2;
                if(prefix[m]-prefix[left]>prefix[prefix.length-1]-prefix[m]){
                    r=m;
                }
                else{
                    l = m+1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,2,2,2,5,0]"));
    }
}

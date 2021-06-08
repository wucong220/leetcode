package com.wu;

/**
 * @author wuc006
 * @date 2021/3/29 16:53
 */
public class CN1802 {
    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int l=0;
            int r=maxSum+1;
            while(l<r){
                int m = l + (r-l)/2;
                if(getSum(m,index,n)>maxSum){
                    r = m;
                }
                else{
                    l = m +1;
                }
            }
            return l-1;
        }

        long getSum(int nums_index,int index,int n){
            int left_count = Math.max(0,Math.min(nums_index-1,index));
            int right_count = Math.max(0,Math.min(n-1-index,nums_index-1));
            int nums_0 = nums_index- left_count;
            int nums_n_1 = nums_index - right_count;
            long preSum = ((long)nums_index + nums_0) * (left_count + 1) / 2;
            long sufSum = ((long)nums_index + nums_n_1) * (right_count +1) / 2;
            return (preSum+sufSum-nums_index+n-left_count-right_count-1);
        }
    }

    public static void main(String[] args) {
        RunUtil.run(6,2,931384943);
    }

    // 6 7 6
    // 8 9 8
}

package com.wu;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wuc006
 * @date 2021/1/4 17:29
 */
public class CN239 {
    class Solution {
        /**
         * 1 <= nums.length <= 105
         * -104 <= nums[i] <= 104
         * 1 <= k <= nums.length
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            LinkedList<Integer> monoQueue = new LinkedList<>();
            LinkedList<Integer> monoIndexQueue = new LinkedList<>();
            int[] ret = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                if(!monoIndexQueue.isEmpty()&&(i-monoIndexQueue.peekLast()+1>k)){
                    monoIndexQueue.pollLast();
                    monoQueue.pollLast();
                }
                while(!monoQueue.isEmpty()&&monoQueue.peekFirst()<nums[i]){
                    monoQueue.pollFirst();
                    monoIndexQueue.pollFirst();
                }
                monoQueue.offerFirst(nums[i]);
                monoIndexQueue.offerFirst(i);
                ret[i] = monoQueue.peekLast();
            }
            return Arrays.copyOfRange(ret,k-1,ret.length);
        }
    }

    public static void main(String[] args) {
        Object run = RunUtil.run(RunUtil.toArray("[1,3,-1,-3,5,3,6,7]"), 3);
        System.out.println(Arrays.toString((int[]) run));
    }
}

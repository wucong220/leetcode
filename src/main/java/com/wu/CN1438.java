package com.wu;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wuc006
 * @date 2021/2/21 10:11
 */
public class CN1438 {
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> maxQueue = new LinkedList<>();
            Deque<Integer> minQueue = new LinkedList<>();
            int left = 0;
            int max = 0;
            for(int i=0;i<nums.length;i++){

                while (!maxQueue.isEmpty()&& nums[i] >= nums[maxQueue.peekFirst()]) {
                    maxQueue.pollFirst();
                }
                maxQueue.offerFirst(i);
                while (!minQueue.isEmpty()&& nums[i] <= nums[minQueue.peekFirst()]) {
                    minQueue.pollFirst();
                }
                minQueue.offerFirst(i);

                while(nums[maxQueue.peekLast()]-nums[minQueue.peekLast()]>limit){
                    int out = 0;
                    if(maxQueue.peekLast()<minQueue.peekLast()){
                        out = maxQueue.pollLast();
                    }
                    else{
                        out = minQueue.pollLast();
                    }
                    left = out+1;
                }

                max = Math.max(i-left+1,max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,8,6,10]"),8);
    }
}

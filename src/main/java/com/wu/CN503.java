package com.wu;

import java.util.Arrays;
import java.util.LinkedList;

public class CN503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] help = new int[nums.length*2];
            for(int i=0;i<nums.length;i++){
                help[i] = nums[i];
                help[i+nums.length]=nums[i];
            }
            int[] ret = new int[nums.length];
            LinkedList<Integer> monoStack = new LinkedList<>();
            for(int i=nums.length*2-1;i>=0;i--){
                while(!monoStack.isEmpty()&&monoStack.peek()<=help[i]){
                    monoStack.pop();
                }
                if(i<nums.length) {
                    if (monoStack.isEmpty()) {
                        ret[i] = -1;
                    } else {
                        ret[i] = monoStack.peek();
                    }
                }
                monoStack.push(help[i]);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString((int[]) RunUtil.run(RunUtil.toArray("[1,2,1]"))));
    }
}

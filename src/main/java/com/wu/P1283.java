package main.java.com.wu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuc006
 * @date 2019/12/9 10:45
 */
public class P1283 {
    class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int left = 1;
            int right = 1000_000;
            while (left < right) {
                int divisor = left + (right - left) / 2;
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    sum += Math.ceil((float) nums[i] / divisor);
                }
                if (sum > threshold) {
                    left = divisor + 1;
                } else if (sum <= threshold) {
                    right = divisor;
                }
            }
            int sum=0;
            int divisor=left;
            for (int i = 0; i < nums.length; i++) {
                sum += Math.ceil((float) nums[i] / divisor);
            }
            if(sum>threshold)
                return left+1;
            else {
                return left;
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{1,2,3},6);
    }
}

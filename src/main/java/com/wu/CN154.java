package com.wu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wuc006
 * @date 2021/4/9 9:23
 */
public class CN154 {
    class Solution {
        public int findMin(int[] nums) {
            return Arrays.stream(nums).min().getAsInt();
    }
    }
}

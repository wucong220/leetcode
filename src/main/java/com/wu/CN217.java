package com.wu;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wuc006
 * @date 2020/12/18 11:38
 */
public class CN217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            return Arrays.stream(nums).distinct().count() ==nums.length;
        }
    }
}

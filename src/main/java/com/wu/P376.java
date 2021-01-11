package com.wu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/12/18 11:44
 */
public class P376 {
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                while (i < nums.length - 1 && nums[i + 1] == nums[i]) {
                    i++;
                }
                list.add(nums[i]);
            }

            if (list.size() <= 1) return list.size();
            int[] gaps = new int[list.size() - 1];

            for (int i = 0; i < list.size() - 1; i++) {
                gaps[i] = list.get(i + 1) - list.get(i);
            }

            int ret = 0;
            for (int i = 0; i < gaps.length - 1; i++) {
                if ((gaps[i] < 0 && gaps[i + 1] > 0) || (gaps[i] > 0 && gaps[i + 1] < 0)) {
                    ret++;
                }
            }

            return ret + 2;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{1, 2, 2, 2, 1});
    }
}

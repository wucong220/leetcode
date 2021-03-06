package com.wu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2021/2/3 11:23
 */
public class CN989 {
    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> ret = new ArrayList<>();
            for (int a : A) {
                ret.add(a);
            }
            for (int i = ret.size() - 1; i >= 0; i--) {
                Integer curr = ret.get(i);
                curr = curr + K;
                K = curr / 10;
                curr = curr % 10;
                ret.set(i, curr);
            }
            while (K > 0) {
                ret.add(0, K%10);
                K=K/10;
            }
            return ret;
        }
    }
}

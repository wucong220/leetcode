package com.wu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wuc006
 * @date 2021/8/6 17:16
 */
public class CN1953 {
    class Solution {
        public long numberOfWeeks(int[] milestones) {
            Arrays.sort(milestones);
            long sum = Arrays.stream(milestones).limit(milestones.length - 1).mapToLong(a->a).reduce(Long::sum).orElse(0L);
            if(milestones[milestones.length-1]>sum+1)return 2L*sum+1L;
            else return sum+milestones[milestones.length-1];
        }
    }
}

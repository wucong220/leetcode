package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/6/17 15:25
 */
public class CN1900 {
    class Solution {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> mem = new HashSet<>();

        public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
            int status = (1 << (n + 1)) - 1;
            earliestAndLatest(n, firstPlayer, secondPlayer, 1, status);
            return new int[]{min, max};
        }

        public void earliestAndLatest(int n, int firstPlayer, int secondPlayer, int step, int status) {
            if (mem.contains(status)) return;
            mem.add(status);
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (((status >> i) & 1) == 1) {
                    list.add(i);
                }
            }
            List<Integer> statuses = new ArrayList<>();
            statuses.add(0);
            while (list.size() > 0) {
                Integer first = list.pollFirst();
                if (list.size() > 0) {
                    Integer last = list.pollLast();
                    if (first == firstPlayer && secondPlayer == last) {
                        min = Math.min(min, step);
                        max = Math.max(max, step);
                        return;
                    }
                    List<Integer> temp = new ArrayList<>();
                    for (Integer tempStatus : statuses) {
                        if (last != firstPlayer && last != secondPlayer) temp.add(tempStatus | (1 << first));
                        if (first != firstPlayer && first != secondPlayer) temp.add(tempStatus | (1 << last));
                    }
                    statuses = temp;
                } else {
                    for (int i = 0; i < statuses.size(); i++) {
                        statuses.set(i, statuses.get(i) | (1 << first));
                    }
                }
            }
            for (Integer s : statuses) {
                earliestAndLatest(n, firstPlayer, secondPlayer, step + 1, s);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString((int[]) RunUtil.run(11, 2, 4)));
    }
}

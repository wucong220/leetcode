package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/12/31 15:53
 */
public class CN1707 {
    class SuffixNode {
        int val;
        SuffixNode[] next;
        int min = Integer.MAX_VALUE;

        public SuffixNode(int val) {
            this.val = val;
        }
    }


    class Solution {
        public int[] maximizeXor(int[] nums, int[][] queries) {
            SuffixNode root = new SuffixNode(0);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                min = Math.min(nums[i], min);
                SuffixNode pre = root;
                for (int j = 31; j >= 0; j--) {
                    int n = nums[i];
                    int currBit = ((n >>> j) & 1);
                    if (pre.next == null) pre.next = new SuffixNode[2];
                    if (currBit == 0) {
                        if (pre.next[0] == null) {
                            pre.next[0] = new SuffixNode(0);
                        }
                        if (nums[i] < pre.next[0].min) pre.next[0].min = nums[i];
                        pre = pre.next[0];
                    } else {
                        if (pre.next[1] == null) {
                            pre.next[1] = new SuffixNode(1);
                        }
                        if (nums[i] < pre.next[1].min) pre.next[1].min = nums[i];
                        pre = pre.next[1];
                    }
                }
            }
            int[] answer = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int xi = queries[i][0];
                int mi = queries[i][1];
                if (mi < min) {
                    answer[i] = -1;
                    continue;
                }
                SuffixNode p = root;
                for (int j = 31; j >= 0; j--) {
                    int currBit = ((xi >>> j) & 1);
                    if (currBit == 0) {
                        if (p.next[1] != null&&mi>=p.next[1].min) {
                            answer[i] ^= 1 << j;
                            p = p.next[1];
                        } else {
                            p = p.next[0];
                        }
                    } else {
                        if (p.next[0] != null&&mi>=p.next[0].min) {
                            answer[i] ^= 1 << j;
                            p = p.next[0];
                        } else {
                            p = p.next[1];
                        }
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Object run = RunUtil.run(RunUtil.toArray("[536870912,0,534710168,330218644,142254206]"), RunUtil.toArray("[[214004,404207941]]"));
        System.out.println(Arrays.toString((int[]) run));
    }
}

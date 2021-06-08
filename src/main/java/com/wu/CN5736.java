package com.wu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CN5736 {
    class Solution {
        public int[] getOrder(int[][] tasks) {
            int[] ret = new int[tasks.length];
            int index = 0;
            PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> tasks[a][0] - tasks[b][0]);
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.comparingInt(a -> tasks[(int) a][1]).thenComparingInt(b-> (int) b));
            for (int i = 0; i < tasks.length; i++) {
                pq1.offer(i);
            }
            Integer curr = null;
            while(!pq1.isEmpty()||!pq2.isEmpty()) {
                if (curr == null) {
                    int peek = pq1.peek();
                    curr = tasks[peek][0];
                }
                while (!pq1.isEmpty()) {
                    int peek1 = pq1.peek();
                    if (tasks[peek1][0] <= curr) {
                        pq2.offer(pq1.poll());
                    } else {
                        break;
                    }
                }

                if (!pq2.isEmpty()) {
                    int poll = pq2.poll();
                    ret[index++] = poll;
                    int t = tasks[poll][1];
                    curr+=t;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray(
                "[[100,100],[1000000000,1000000000]]"));
    }
}

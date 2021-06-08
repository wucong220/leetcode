package com.wu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wuc006
 * @date 2021/2/28 14:19
 */
public class CN5691 {
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int gap = Arrays.stream(nums1).reduce(Integer::sum).getAsInt() - Arrays.stream(nums2).reduce(Integer::sum).getAsInt();
            if(gap <0){
                return help(nums1,nums2,-gap);
            }
            else if (gap>0){
                return help(nums2,nums1,gap);
            }
            return 0;
        }

        public int help(int[] nums1,int[] nums2,int gap){
            int ret = 0;
            PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b)->a-b);
            for (int i : nums1) {
                pq1.add(i);
            }
            PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b)->b-a);
            for (int i : nums2) {
                pq2.add(i);
            }
            while(gap>0){
                if(pq1.isEmpty()&&pq2.isEmpty())return -1;
                if(!pq1.isEmpty()&&!pq2.isEmpty()) {
                    int peek1 = pq1.peek();
                    int peek2 = pq2.peek();
                    if (peek1 == 6 && peek2 == 1) return -1;

                    if (6 - peek1 > peek2 - 1) {
                        pq1.poll();
                        ret++;
                        gap -= 6 - peek1;
                        if (gap <= 0) return ret;
                    } else {
                        pq2.poll();
                        ret++;
                        gap -= peek2 - 1;
                        if (gap <= 0) return ret;
                    }
                }else if(!pq1.isEmpty()){
                    int peek1 = pq1.peek();
                    if (peek1 == 6) return -1;
                    pq1.poll();
                    ret++;
                    gap -= 6 - peek1;
                    if (gap <= 0) return ret;
                }else{
                    int peek2 = pq2.peek();
                    if (peek2 == 1) return -1;
                    pq2.poll();
                    ret++;
                    gap -= peek2 - 1;
                    if (gap <= 0) return ret;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[6,6]"),RunUtil.toArray("[1]"));
    }
}

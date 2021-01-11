package com.wu;
import java.util.*;
/**
 * @author wuc006
 * @date 2020/4/24 15:30
 */
public class P1402 {
    class Solution {
        public int maxSatisfaction(int[] satisfaction) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i : satisfaction) {
                pq.offer(i);
            }
            LinkedList<Integer> list = new LinkedList<>();
            while(!pq.isEmpty()){
                Integer poll = pq.poll();
                int sum =0;
                int oldSum = 0;
                for (int i = 0; i < list.size(); i++) {
                    Integer integer = list.get(i);
                    sum+=integer*(i+2);
                    oldSum += integer*(i+1);
                }
                if(oldSum<sum+poll){
                    list.addFirst(poll);
                }
            }
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                Integer integer = list.get(i);
                sum+=integer*(i+1);
            }
            return sum ;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{-2,5,-1,0,3,-3});
    }
}

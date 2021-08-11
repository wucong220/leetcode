package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/6/21 10:40
 */
public class LCS02 {
    class Solution {
        public int halfQuestions(int[] questions) {
            int n = questions.length/2;
            Map<Integer,Integer> map = new HashMap<>();
            for (int question : questions) {
                map.merge(question,1,Integer::sum);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
            pq.addAll(map.keySet());
            int ctr=0;
            while (!pq.isEmpty()){
                n-=map.get(pq.poll());
                ctr++;
                if(n<=0)return ctr;
            }
            return ctr;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[3,13,7,11,1,5,5,3]"));
    }
}

package com.wu;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CN5803 {
    class Solution {
        public int eliminateMaximum(int[] dist, int[] speed) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(a->1.0*dist[(int)a]/speed[(int)a]));
            for(int i=0;i<speed.length;i++){
                pq.offer(i);
            }
            int ctr = 0;
            int time = 0;
            while(!pq.isEmpty()){
                Integer poll = pq.poll();
                if(1.0*dist[poll]/speed[poll]>time){
                    ctr++;
                }
                else{
                    break;
                }
                time++;
            }
            return ctr;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[3,2,4]"),RunUtil.toArray("[5,3,2]"));
    }
}

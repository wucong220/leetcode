package com.wu;

import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 * @author wuc006
 * @date 2021/7/31 18:53
 */
public class CN1942 {
    class Solution {
        public int smallestChair(int[][] times, int targetFriend) {
            TreeSet<Integer> set = new TreeSet<>();
            IntStream.range(0,times.length).forEach(set::add);
            Integer[] index = new Integer[times.length];
            Arrays.setAll(index,a->a);
            Arrays.sort(index,Comparator.comparing(a->times[a][0]));
            Arrays.sort(times,Comparator.comparing(a->a[0]));
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            for(int i=0;i<times.length;i++){
                int arrive = times[i][0];
                int leave = times[i][1];
                while(!pq.isEmpty()&&pq.peek()[0]<=arrive){
                    int[] poll = pq.poll();
                    set.add(poll[1]);
                }
                Integer integer = set.pollFirst();
                if(index[i]==targetFriend)return integer;
                else{
                    pq.offer(new int[]{leave,integer});
                }
            }
            return 1111;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[33889,98676],[80071,89737],[44118,52565],[52992,84310],[78492,88209],[21695,67063],[84622,95452],[98048,98856],[98411,99433],[55333,56548],[65375,88566],[55011,62821],[48548,48656],[87396,94825],[55273,81868],[75629,91467]]"),6);
    }
}

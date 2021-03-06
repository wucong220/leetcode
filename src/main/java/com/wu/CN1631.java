package com.wu;

import java.util.*;
import java.util.function.BiFunction;

/**
 * @author wuc006
 * @date 2021/1/29 11:47
 */
public class CN1631 {
    class Solution {
        class BiTuple{
            int i;
            int j;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                BiTuple biTuple = (BiTuple) o;
                return i == biTuple.i &&
                        j == biTuple.j;
            }

            public BiTuple(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        public int minimumEffortPath(int[][] heights) {
            long max = Integer.MIN_VALUE;
            boolean used[][] = new boolean[heights.length][heights[0].length];
            long ab[][] = new long[heights.length][heights[0].length];
            for(int i=0;i<ab.length;i++){
                Arrays.fill(ab[i],Integer.MAX_VALUE);
            }
            PriorityQueue<BiTuple> pq = new PriorityQueue<>(Comparator.comparingLong(a -> ab[a.i][a.j]));
            pq.offer(new BiTuple(0,0));
            ab[0][0]=0;
            while(!pq.isEmpty()){
                BiTuple curr = pq.poll();
                int i = curr.i;
                int j = curr.j;
                max = Math.max(max,ab[i][j]);
                if(i==heights.length-1&&j==heights[0].length-1){
                    break;
                }
                used[i][j]=true;
                if(i>0&&!used[i-1][j]){
                    ab[i-1][j]=Math.min(Math.abs(heights[i-1][j]-heights[i][j]),ab[i-1][j]);
                    pq.remove(new BiTuple(i-1,j));
                    pq.offer(new BiTuple(i-1,j));
                }
                if(i<heights.length-1&&!used[i+1][j]){
                    ab[i+1][j]=Math.min(Math.abs(heights[i+1][j]-heights[i][j]),ab[i+1][j]);
                    pq.remove(new BiTuple(i+1,j));
                    pq.offer(new BiTuple(i+1,j));
                }
                if(j>0&&!used[i][j-1]){
                    ab[i][j-1]=Math.min(Math.abs(heights[i][j-1]-heights[i][j]),ab[i][j-1]);
                    pq.remove(new BiTuple(i,j-1));
                    pq.offer(new BiTuple(i,j-1));
                }
                if(j<heights[0].length-1&&!used[i][j+1]){
                    ab[i][j+1]=Math.min(Math.abs(heights[i][j+1]-heights[i][j]),ab[i][j+1]);
                    pq.remove(new BiTuple(i,j+1));
                    pq.offer(new BiTuple(i,j+1));
                }
            }
            return (int)max;
        }

    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[4,3,4,10,5,5,9,2],[10,8,2,10,9,7,5,6],[5,8,10,10,10,7,4,2],[5,1,3,1,1,3,1,9],[6,4,10,6,10,9,4,6]]"));
    }
}

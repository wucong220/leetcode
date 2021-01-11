package com.wu;

import java.util.PriorityQueue;

/**
 * @author wuc006
 * @date 2020/5/13 16:53
 */
public class P1439 {
    class Solution{
        public int kthSmallest(int[][] mat, int k) {
            int n = mat.length;
            int[][] minus = new int[mat.length][mat[0].length];
            int[] index = new int[mat.length];
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    minus[i][j] = mat[i][j]-(j>0?minus[i][j-1]:0);
                }
            }
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
            int sum = 0;
            for (int i = 0; i < mat.length; i++) {
                sum += minus[i][index[i]++];
                pq.offer(new int[]{minus[i][index[i]],i});
            }

            for(int i=1;i<k;i++) {
                int[] minMinus = pq.poll();
                int minMinusValue = minMinus[0];
                int minMinusIndex = minMinus[1];
                sum+=minMinusValue;
                index[minMinusIndex]++;
                if(index[minMinusIndex]<mat[0].length) {
                    pq.offer(new int[]{minus[minMinusIndex][index[minMinusIndex]], minMinusIndex});
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[1,3,11],[2,4,6]]"),5);
    }
}

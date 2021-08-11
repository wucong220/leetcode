package com.wu;

import javafx.scene.layout.Priority;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wuc006
 * @date 2021/8/3 14:45
 */
public class CN1337 {
    class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(a->-power((int)a,mat)).thenComparing(a->-(int)a));
            for (int i = 0, matLength = mat.length; i < matLength; i++) {
                int[] n = mat[i];
                pq.offer(i);
                if (pq.size()>k){
                    pq.poll();
                }
            }
            int[] ret = new int[pq.size()];
            for (int i = ret.length - 1; i >= 0; i--) {
                ret[i] = pq.poll();
            }
            return ret;
        }

        private int power(int a, int[][] mat) {
            final int[] n = mat[a];
            int l=0;
            int r=n.length;
            while(l<r){
                int m = l + (r - l)/2;
                if(n[m]==0){
                    r = m;
                }
                else{
                    l = m + 1;
                }
            }
            return l;
        }

    }
}

package com.wu;

/**
 * @author wuc006
 * @date 2020/11/9 16:12
 */

/**
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 */

/**
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class CN973 {
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
            for (int[] point : points) {
                pq.offer(point);
            }
            int[][] ret = new int[K][];
            for(int i=0;i<K;i++){
                ret[i] = pq.poll();
            }
            return ret;
        }
    }
}

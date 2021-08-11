package com.wu;

import java.util.Arrays;

public class CN5815 {
    class Solution {
        public long maxPoints(int[][] points) {
            int[] max = new int[points[0].length];
            for (int i = 0; i < points.length; i++) {
                int[] lmax = new int[max.length];
                int[] rmax = new int[max.length];
                for (int k = 0; k < points[i].length; k++) {
                    lmax[k] = Math.max(k==0?Integer.MIN_VALUE:lmax[k-1],max[k]+k);
                }
                for (int k = points[i].length - 1; k >=0 ; k--) {
                    rmax[k] = Math.max(k==points[i].length - 1?Integer.MIN_VALUE:rmax[k+1],max[k]-k);
                }

                for (int j = 0; j < points[i].length; j++) {
                    max[j] = Math.max(lmax[j]+points[i][j]-j,j==points[i].length-1?Integer.MIN_VALUE:rmax[j+1]+points[i][j]+j);

//                        if (k <= j) {
//                            temp[j] = Math.max(temp[j], points[i][j] - j + max[k] + k);
//                        } else {
//                            temp[j] = Math.max(temp[j], points[i][j] + j + max[k] - k);
//                        }

                }
            }
            int ret = 0;
            for (int i = 0; i < max.length; i++) {
                ret = Math.max(max[i], ret);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[1,2,3],[1,5,1],[3,1,1]]"));
    }
}

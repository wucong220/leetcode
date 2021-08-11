package com.wu;

import java.util.Arrays;

public class CN149 {
    class Solution {
        public int maxPoints(int[][] points) {
            int max = Integer.MIN_VALUE;
            for(int i=0;i<points.length;i++){
                for(int j=i+1;j<points.length;j++){
                    int ctr = 2;
                    for(int k=j+1;k<points.length;k++){
                        if((points[i][0]-points[j][0])*(points[i][1]-points[k][1])==(points[i][1]-points[j][1])*(points[i][0]-points[k][0])){
                            ctr++;
                        }
                    }
                    max = Math.max(ctr,max);
                }
            }
            return max;
        }
    }

    public static void main(String[] args){

    }
}

//package com.wu;
//
//public class CN1473 {
//    class Solution {
//        public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
//            int d[][] = new int[m][target+1];
//            for(int i=0;i<m;i++){
//                for(int j=1;j<=target;j++){
//                    if(i==0){
//                        if(j==1)d[i][j]=findMin(cost[i],houses);
//                        else d[i][j]=-1;
//                    }
//                    else{
//                        if(j==1)d[i][j]=findMin(cost,houses,0,i);
//                    }
//                }
//            }
//        }
//
//        private int findMin(int[][] cost, int[] houses, int i, int j) {
//            int ret = Integer.MAX_VALUE;
//            for(int l=0;l<cost[0].length;l++) {
//                int temp = 0;
//                for (int k = i; k <= j; k++) {
//                    if(houses[k]==l+1){
//                        temp+=0;
//                    }
//                    else temp+=cost[k][l];
//                }
//                ret = Math.min(ret,temp);
//            }
//            return ret;
//        }
//
//        private int findMin(int[] ints,int[] houses) {
//        }
//    }
//}

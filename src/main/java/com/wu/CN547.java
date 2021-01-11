package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/1/7 8:57
 */


public class CN547 {
    class AndCheckSet {
        int[] f;

        public AndCheckSet(int size){
            f = new int[size];
            for(int i=0;i<size;i++){
                f[i]=i;
            }
        }

        int findParent(int a){
            while(f[a]!=a){
                a = f[a];
            }
            return a;
        }

        boolean isSameSet(int a,int b){
            return findParent(a)==findParent(b);
        }

        void pathCompression(int a,int n){
            while(f[a]!=n){
                int temp = f[a];
                f[a] = n;
                a = temp;
            }
        }

        void union(int a,int b){
            int aP = findParent(a);
            int bP = findParent(b);
            if (aP != bP) {
                pathCompression(a,bP);
                pathCompression(b,bP);
            }
        }

        int count(){
            for (int i=0;i<f.length;i++) {
                int p = findParent(i);
                pathCompression(i,p);
            }
            return (int) Arrays.stream(f).distinct().count();
        }
    }

    class Solution {
        public int findCircleNum(int[][] isConnected) {
            AndCheckSet acs = new AndCheckSet(isConnected.length);
            for (int i = 0; i < isConnected.length; i++) {
               for(int j = 0;j<isConnected[0].length;j++){
                   if(isConnected[i][j]==1){
                       acs.union(i,j);
                   }
               }
            }
            return acs.count();
        }
    }

    public static void main(String[] args) {
        System.out.println(RunUtil.run(RunUtil.toArray("" +
                "[[1,0,0,1]," +
                "[0,1,1,0]," +
                "[0,1,1,1]," +
                "[1,0,1,1]]")));
    }
}

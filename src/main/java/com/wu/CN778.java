package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/2/2 16:27
 */
public class CN778 {
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
        public int swimInWater(int[][] grid) {
            int N = grid.length;
            AndCheckSet acs = new AndCheckSet(N * N);
            for(int t = 0; t< N * N; t++){
                   for(int i = 0; i< N; i++){
                       for(int j = 0; j< N; j++){
                           if(i>0&&Math.max(grid[i-1][j],t)==Math.max(grid[i][j],t))
                           acs.union((i-1)* N +j,i* N +j);
                           if(i< N -1&&Math.max(grid[i+1][j],t)==Math.max(grid[i][j],t))
                           acs.union((i+1)* N +j,i* N +j);
                           if(j>0&&Math.max(grid[i][j-1],t)==Math.max(grid[i][j],t))
                           acs.union(i* N +j-1,i* N +j);
                           if(j< N -1&&Math.max(grid[i][j+1],t)==Math.max(grid[i][j],t))
                           acs.union(i* N +j+1,i* N +j);
                       }

                   }
                if(acs.isSameSet(0, N * N -1))return t;
            }
            return 0;
        }
    }
}

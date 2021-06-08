package com.wu;

/**
 * @author wuc006
 * @date 2021/2/24 9:23
 */
public class CN832 {
    class Solution {
        public int[][] flipAndInvertImage(int[][] A) {
            for(int i=0;i<A.length;i++){
                reverse(A[i]);
                for(int j=0;j<A[i].length;j++){
                    A[i][j] = 1-A[i][j];
                }
            }
            return A;
        }

        void reverse(int[] a){
            for(int l=0,r=a.length-1;l<r;l++,r--){
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
            }
        }
    }
}

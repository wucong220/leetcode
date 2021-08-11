package com.wu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Test {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            for(int i=m;i<A.length;i++){
                A[i] = B[i-m];
                for(int j=i-1;j>0;j--){
                    if(A[j]>A[j+1]){
                        int temp = A[j];
                        A[j] = A[j+1];
                        A[j+1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run("0&0&0&1^1|0",1);
    }
}

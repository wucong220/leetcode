package com.wu;

/**
 * @author wuc006
 * @date 2021/3/30 16:51
 */
public class CN1806 {
    class Solution {
        public int reinitializePermutation(int n) {
            int[] perm = new int[n];
            for(int i=0;i<n;i++)perm[i]=i;
            for(int j=1;;j++) {
                int[] arr = new int[n];
                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        arr[i] = perm[i / 2];
                    } else {
                        arr[i] = perm[n / 2 + (i - 1) / 2];
                    }
                    if(arr[i]!=i)flag=false;
                }
                if(flag)return j;
                perm=arr;
            }
        }
    }
}

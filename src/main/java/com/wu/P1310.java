package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/1/22 16:57
 */
public class P1310 {
    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] ret = new int[queries.length];
            for(int i=0;i<queries.length;i++){
                int[] query=queries[i];
                for(int j=query[0];j<=query[1];j++) {
                    ret[i] = ret[i] ^ arr[j];
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        String[] split = " ".split(",", -1);
        System.out.println(Arrays.toString(split));
    }


}

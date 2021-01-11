package com.wu;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuc006
 * @date 2020/5/11 14:16
 */
public class P1442 {
    class Solution {
        public int countTriplets(int[] arr) {
            int ret = 0;
            int[][] xorTbl = new int[arr.length][arr.length];
            //O(n^2)
            for(int i=0;i<arr.length;i++){
                for(int j=i;j<arr.length;j++){
                    if(i==j){
                        xorTbl[i][j]=arr[i];
                    }
                    else{
                        xorTbl[i][j]=xorTbl[i][j-1]^arr[j];
                    }
                }
            }

            for(int i=0;i<=arr.length-2;i++){
                Map<Integer,List<Integer>> toI = new HashMap<>();
                for(int j=0;j<=i;j++){
                    toI.putIfAbsent(xorTbl[j][i],new ArrayList<>());
                    List<Integer> list = toI.get(xorTbl[j][i]);
                    list.add(j);
                }
                for(int k=i+1;k<arr.length;k++){
                    if(toI.containsKey(xorTbl[i+1][k])){
                        List<Integer> list = toI.get(xorTbl[i+1][k]);
                        ret+=list.size();
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{2,3,1,6,7});
    }
}

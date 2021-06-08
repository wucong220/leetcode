package com.wu;


import java.util.HashSet;
import java.util.Set;

/**
 * @author wuc006
 * @date 2020/1/19 9:39
 */
public class P1319 {
    class Solution {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }
            int[] union = new int[n];
            for (int i = 0; i < union.length; i++) {
                union[i] = i;
            }
            for (int i = 0; i < connections.length; i++) {
                connect(connections[i][0],connections[i][1],union);
            }
            for(int i=0;i<union.length;i++){
                find(i,union);
            }
            Set<Integer> set = new HashSet<>();
            for (int i : union) {
                set.add(i);
            }
            return set.size()-1;
        }
        private int find(int n,int[] union){
            int temp = n;
            while(union[temp]!=temp){
                temp=union[temp];
            }
            int target = temp;
            temp = n;
            while(union[temp]!=temp){
                int t = union[temp];
                union[temp] = target;
                temp = t;
            }
            return target;
        }

        private void connect(int a,int b,int[] union){
            if((a=find(a,union))!=(b=find(b,union))){
                union[a]=b;
            }
        }
    }


    public static void main(String[] args) {
        RunUtil.run(5,new int[][]{{0,1},{0,2},{3,4},{2,3}});
    }
}

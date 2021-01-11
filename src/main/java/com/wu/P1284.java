package com.wu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author wuc006
 * @date 2019/12/9 16:38
 */
public class P1284 {
    class Solution {
        /*  m == mat.length
            n == mat[0].length
            1 <= m <= 3
            1 <= n <= 3
            mat[i][j] is 0 or 1.    */
        public int minFlips(int[][] mat) {
            short originalStatus =0;
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[i].length;j++){
                    originalStatus|=mat[i][j]<<(i*mat[i].length+j);
                }
            }
            Set<Short> statusChecked = new HashSet<>();
            LinkedList<Short> queue = new LinkedList<>();
            queue.offer(originalStatus);
            int count=0;
            while(!queue.isEmpty()){
                int size = queue.size();
                count++;
                for (int k=0;k<size;k++){
                    Short poll = queue.poll();
                    if((poll|0)==0){
                        return count-1;
                    }
                    else{
                        for(int i=0;i<mat.length;i++){
                            for(int j=0;j<mat[i].length;j++){
                                short newStatus = statusSwap(poll,i,j,mat.length,mat[i].length);
                                if(!statusChecked.contains(newStatus)){
                                    statusChecked.add(newStatus);
                                    queue.offer(newStatus);
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private short statusSwap(short status,int x,int y,int x_length,int y_length){
            status^=1<<(x*y_length+y);
            if(x<x_length-1) status^=1<<((x+1)*y_length+y);
            if(x>0) status^=1<<((x-1)*y_length+y);
            if(y<y_length-1) status^=1<<(x*y_length+(y+1));
            if(y>0) status^=1<<(x*y_length+(y-1));
            return status;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[][][]{{{1,0,0},{1,0,0}}});
    }
}

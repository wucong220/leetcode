package com.wu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/6/28 10:04
 */
public class CN909 {
    class Solution {
        public int snakesAndLadders(int[][] board) {
            LinkedList<Integer> q = new LinkedList<>();
            int[] b = new int[board.length*board[0].length];
            int k=0;
            for(int i=board.length-1;i>=0;i--){
                if((i-board.length+1)%2==0) {
                    for (int j = 0; j < board[i].length; j++) {
                        b[k++] = board[i][j];
                    }
                }
                else{
                    for (int j = board[i].length - 1; j >= 0; j--) {
                        b[k++] = board[i][j];
                    }
                }
            }

            q.offer(1);
            Set<Integer> mem = new HashSet<>();
            mem.add(1);
            int ret = 0;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    Integer poll = q.poll();
                    if(poll == b.length)return ret;
                    for(int j=1;j<=6&&poll+j-1<b.length;j++){
                        if(b[poll+j-1]!=-1){
                            if(!mem.contains(b[poll+j-1])){
                                mem.add(b[poll + j - 1]);
                                q.offer(b[poll + j - 1]);
                            }
                        }
                        else if(!mem.contains(poll+j)){
                            mem.add(poll+j);
                            q.offer(poll+j);
                        }
                    }
                }
                ret++;
            }
            return-1;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[1,1,-1],[1,1,1],[-1,1,1]]"));
    }
}

package com.wu;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/6/28 11:07
 */
public class CN773 {
    class Solution {
        public int slidingPuzzle(int[][] board) {
            LinkedList<Integer> q = new LinkedList<>();
            int finalStatus = encode(new int[][]{{1,2,3},{4,5,0}});
            int initStatus = encode(board);
            Set<Integer> mem = new HashSet<>();
            q.offer(initStatus);
            mem.add(initStatus);
            int ret = 0;
            while(!q.isEmpty()){
                int size = q.size();
                for(int i=0;i<size;i++){
                    Integer status = q.poll();
                    if(status==finalStatus){
                        return ret;
                    }
                    int[][] decode = decode(status);
                    for(int j=0;j<decode.length;j++){
                        for(int k=0;k<decode[j].length;k++){
                            if(decode[j][k]==0){
                                if(j<decode.length-1) {
                                    swap(decode, j, k, j + 1, k);
                                    int encode = encode(decode);
                                    if(!mem.contains(encode)){
                                        mem.add(encode);
                                        q.offer(encode);
                                    }
                                    swap(decode, j, k, j + 1, k);
                                }
                                if(j>0) {
                                    swap(decode, j-1, k, j, k);
                                    int encode = encode(decode);
                                    if(!mem.contains(encode)){
                                        mem.add(encode);
                                        q.offer(encode);
                                    }
                                    swap(decode, j-1, k, j, k);
                                }
                                if(k<decode[j].length-1) {
                                    swap(decode, j, k, j , k+1);
                                    int encode = encode(decode);
                                    if(!mem.contains(encode)){
                                        mem.add(encode);
                                        q.offer(encode);
                                    }
                                    swap(decode, j, k, j, k+1);
                                }
                                if(k>0) {
                                    swap(decode, j, k, j, k-1);
                                    int encode = encode(decode);
                                    if(!mem.contains(encode)){
                                        mem.add(encode);
                                        q.offer(encode);
                                    }
                                    swap(decode, j, k, j, k-1);
                                }
                            }
                        }
                    }

                }
                ret++;
            }
            return -1;
        }

        private void swap(int[][] decode, int j, int k, int j1, int k1) {
            int temp = decode[j][k];
            decode[j][k] = decode[j1][k1];
            decode[j1][k1] = temp;
        }


        private int encode(int[][] board) {
            int ret = 0;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    int blockValue = board[i][j];
                    int blockSize = 3;
                    int blockNum = i*3+j;
                    ret|=blockValue<<(blockNum*blockSize);
                }
            }
            return ret;
        }
        private int[][] decode(int status) {
            int[][] board = new int[2][3];
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[i].length;j++){
                    int blockSize = 3;
                    int blockNum = i*3+j;
                    int blockValue = 7;
                    blockValue &= status>>(blockNum*blockSize);
                    board[i][j] = blockValue;
                }
            }
            return board;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[3,2,4],[1,5,0]]"));
    }
}

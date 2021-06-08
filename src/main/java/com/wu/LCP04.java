package com.wu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/4/23 10:10
 */
public class LCP04 {
    class Solution {
        Map<Long,Integer> mem = new HashMap<>();
        public int domino(int n, int m, int[][] broken) {
            int[][] board = new int[n][m];
            long a=0;
            for (int[] ints : broken) {
                board[ints[0]][ints[1]]= 1;
                a|=1L<<(ints[0]*8+ints[1]);
            }
            return  tryFill(board,a);
        }

        private int tryFill(int[][] board, long a) {
            if(mem.containsKey(a))return mem.get(a);
            int max = 0;
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]==0){
                        if(j<board[0].length-1&&board[i][j+1]==0){
                            board[i][j]=1;
                            board[i][j+1]=1;
                            a|=1L<<(i*8+j);
                            a|=1L<<(i*8+j+1);
                            int next = tryFill(board, a);
                            max = Math.max(1+next,max);
                            a&=~(1L<<(i*8+j));
                            a&=~(1L<<(i*8+j+1));
                            board[i][j]=0;
                            board[i][j+1]=0;
                        }
                        if(i<board.length-1&&board[i+1][j]==0){
                            board[i][j]=1;
                            board[i+1][j]=1;
                            a|=1L<<(i*8+j);
                            a|=1L<<(i*8+8+j);
                            int next = tryFill(board, a);
                            max = Math.max(1+next,max);
                            a&=~(1L<<(i*8+j));
                            a&=~(1L<<(i*8+8+j));
                            board[i][j]=0;
                            board[i+1][j]=0;
                        }
                        board[i][j]=1;
                        a|=1L<<(i*8+j);
                        int next =  tryFill(board, a);
                        max = Math.max(next,max);
                        a&=~(1L<<(i*8+j));
                        board[i][j]=0;
                        mem.put(a,max);
                        return max;
                    }
                }
            }
            mem.put(a,max);
            return max;
        }
    }

    boolean check(int[][] board,long a){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!=(1&(a>>(i*8+j)))){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        RunUtil.run(8,8,new int[][]{{7,2}});
        {
            System.out.println("---------------------------1--------------------------");
            long a = 0b00000000_00000000_00000000_00000000_01111111_11111111_11111111_11111111L;
            long i = 0b00000000_00000000_00000000_00000000_10000000_00000000_00000000_00000000L;
            System.out.println(Long.toBinaryString(a));
            System.out.println(Long.toBinaryString(i));
            System.out.println(Long.toBinaryString( a | i));
        }
        {
            System.out.println("---------------------------2--------------------------");
            long a = 0b00000000_00000000_00000000_00000000_01111111_11111111_11111111_11111111;
            long i = 0b00000000_00000000_00000000_00000000_10000000_00000000_00000000_00000000;
            System.out.println(Long.toBinaryString(a));
            System.out.println(Long.toBinaryString(i));
            System.out.println(Long.toBinaryString( a | i));
        }
        {
            System.out.println("---------------------------3--------------------------");
            long a = 0b00000000_00000000_00000000_00000000_01111111_11111111_11111111_11111111;
            long i = 0b00000000_00000000_00000000_00000000_10000000_00000000_00000000_00000000L;
            System.out.println(Long.toBinaryString(a));
            System.out.println(Long.toBinaryString(i));
            System.out.println(Long.toBinaryString( a | i));
        }
        {
            System.out.println("---------------------------4--------------------------");
            long a = 0b00000000_00000000_00000000_00000000_01111111_11111111_11111111_11111111L;
            long i = 0b00000000_00000000_00000000_00000000_10000000_00000000_00000000_00000000;
            System.out.println(Long.toBinaryString(a));
            System.out.println(Long.toBinaryString(i));
            System.out.println(Long.toBinaryString( a | i));
        }
        {
            System.out.println("---------------------------5--------------------------");
            long a = 1;
            System.out.println(Long.toBinaryString(a<<58));
            System.out.println(Long.toBinaryString( 1<< 26));
        }
    }
}

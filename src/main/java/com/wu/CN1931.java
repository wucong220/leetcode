package com.wu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/7/21 16:32
 */
public class CN1931 {
    class Solution {
        int mod = (int) (1e9 + 7);
        Map<Long,Integer> mem = new HashMap<>();
        public int colorTheGrid(int m, int n) {
            int[][] board = new int[n][m];
            //1-red //2-blue //3-green
            int dfs = dfs(board, 0, 0);
            return dfs;
        }

        private int dfs(int[][] board, int x, int y) {
            Long m = getMem(board,x,y);
            if(mem.containsKey(m)){
                return mem.get(m);
            }
            int ret = 0;
            int preX = x==0?0:board[x - 1][y];
            int preY = y==0?0:board[x][y - 1];
            for (int i = 1; i <= 3; i++) {
                if (i != preX && i != preY) {
                    board[x][y] = i;
                    if (y == board[x].length - 1) {
                        if (x < board.length - 1) {
                            ret = (ret%mod + dfs(board, x + 1, 0)%mod)%mod;
                        } else ret = (ret%mod + 1%mod)%mod;
                    } else {
                        ret = (ret%mod + dfs(board, x, y + 1)%mod)%mod;
                    }
                }
            }
            mem.put(m,ret);
            return ret;
        }

        private Long getMem(int[][] board, int x, int y) {
            long ret = 0L;
            for(int i=0;i<board[x].length;i++){
                ret|= ((long) board[x][i] )<<(i*2L);
            }
            if(x>0){
                for(int i=0;i<board[x].length;i++){
                    ret|= ((long) board[x-1][i] )<<(i*2L+ 2L *board[x].length);
                }
            }
            ret|=((long)x * board[x].length+y)<<32;
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(RunUtil.run(2,37));
    }
}

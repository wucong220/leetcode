package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/4/30 17:59
 */
public class CN08_12_eightQueen {
    class Solution {
        List<List<String>> ret = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            boolean[][] board = new boolean[n][n];
            solveNQueens(board,0);
            return ret;
        }

        public void solveNQueens(boolean[][] board,int currRow) {
            if(currRow==board.length){
                List<String> solution = new ArrayList<>();
                for (boolean[] row : board) {
                    StringBuilder sb = new StringBuilder();
                    for (boolean b : row) {
                        sb.append(b?'Q':'.');
                    }
                    solution.add(sb.toString());
                }
                ret.add(solution);
            }
            for(int i=0;i<board.length;i++){
                boolean ok = true;
                for(int j=0;j<currRow;j++){
                    if(board[j][i]){
                        ok=false;break;
                    }
                    if(i-(currRow-j)>=0&&board[j][i-(currRow-j)]){
                        ok=false;break;
                    }
                    if(i+(currRow-j)<=board.length-1&&board[j][i+(currRow-j)]){
                        ok=false;break;
                    }
                }
                if(ok){
                    board[currRow][i]=true;
                    solveNQueens(board,currRow+1);
                    board[currRow][i]=false;
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(4);
    }
}

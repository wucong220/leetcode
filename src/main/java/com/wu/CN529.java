package com.wu;

/**
 * @author wuc006
 * @date 2020/8/20 15:49
 */
public class CN529 {
    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {

            adjMine(board,click[0],click[1]);
            return board;
        }

        void adjMine(char[][] board, int x, int y){
            if(x<0||x>=board.length||y<0||y>=board[0].length){
                return;
            }
            if(board[x][y]=='M'){
                board[x][y]='X';
            }
            else if(board[x][y]=='E'){
                int mineCtr=0;
                mineCtr+=countMine(board,x,y-1);
                mineCtr+=countMine(board,x,y+1);
                mineCtr+=countMine(board,x+1,y-1);
                mineCtr+=countMine(board,x+1,y+1);
                mineCtr+=countMine(board,x+1,y);
                mineCtr+=countMine(board,x-1,y-1);
                mineCtr+=countMine(board,x-1,y+1);
                mineCtr+=countMine(board,x-1,y);
                if (mineCtr > 0) board[x][y] = (char) (mineCtr + '0');
                else {
                    board[x][y] = 'B';
                    adjMine(board,x,y-1);
                    adjMine(board,x,y+1);
                    adjMine(board,x+1,y-1);
                    adjMine(board,x+1,y+1);
                    adjMine(board,x+1,y);
                    adjMine(board,x-1,y-1);
                    adjMine(board,x-1,y+1);
                    adjMine(board,x-1,y);
                }
            }
        }
        int countMine(char[][] board, int x, int y){
            if(x<0||x>=board.length||y<0||y>=board[0].length){
                return 0;
            }
            return board[x][y]=='M'?1:0;
        }
    }

    public static void main(String[] args) {
        RunUtil.run();
    }
}

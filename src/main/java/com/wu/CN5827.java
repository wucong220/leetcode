package com.wu;

/**
 * @author wuc006
 * @date 2021/8/9 10:52
 */
public class CN5827 {
    class Solution {
        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
            if(board[rMove][cMove]!='.')return false;

            char negColor = color=='W'?'B':'W';
            boolean checkNeg = true;
            for(int i=rMove+1;i<board.length;i++){
                if (checkNeg) {
                    if (board[i][cMove] != negColor) {
                        break;
                    }
                    else{
                        checkNeg = false;
                    }
                }
                else{
                    if(board[i][cMove] == color)return true;
                }
            }

            checkNeg = true;
            for(int i=rMove-1;i>=0;i--){
                if (checkNeg) {
                    if (board[i][cMove] != negColor) {
                        break;
                    }
                    else{
                        checkNeg = false;
                    }
                }
                else{
                    if(board[i][cMove] == color)return true;
                    else if(board[i][cMove]=='.')break;
                }
            }

            checkNeg = true;
            for(int i=cMove+1;i<board.length;i++){
                if (checkNeg) {
                    if (board[rMove][i] != negColor) {
                        break;
                    }
                    else{
                        checkNeg = false;
                    }
                }
                else{
                    if(board[rMove][i] == color)return true;
                    else if(board[i][cMove]=='.')break;
                }
            }

            checkNeg = true;
            for(int i=cMove-1;i>=0;i--){
                if (checkNeg) {
                    if (board[rMove][i] != negColor) {
                        break;
                    }
                    else{
                        checkNeg = false;
                    }
                }
                else{
                    if(board[rMove][i] == color)return true;
                    else if(board[i][cMove]=='.')break;
                }
            }

            checkNeg = true;
            for(int i=rMove+1,j=cMove+1;i<board.length&&j<board[0].length;i++,j++){
                if (checkNeg) {
                    if (board[i][j] != negColor) {
                        break;
                    }
                    else{
                        checkNeg = false;
                    }
                }
                else{
                    if(board[i][j] == color)return true;
                    else if(board[i][i]=='.')break;
                }
            }

            checkNeg = true;
            for(int i=rMove-1,j=cMove+1;i>=0&&j<board[0].length;i--,j++){
                if (checkNeg) {
                    if (board[i][j] != negColor) {
                        break;
                    }
                    else{
                        checkNeg = false;
                    }
                }
                else{
                    if(board[i][j] == color)return true;
                    else if(board[i][i]=='.')break;
                }
            }

            checkNeg = true;
            for(int i=rMove+1,j=cMove-1;i<board.length&&j>=0;i++,j--){
                if (checkNeg) {
                    if (board[i][j] != negColor) {
                        break;
                    }
                    else{
                        checkNeg = false;
                    }
                }
                else{
                    if(board[i][j] == color)return true;
                    else if(board[i][i]=='.')break;
                }
            }

            checkNeg = true;
            for(int i=rMove-1,j=cMove-1;i>=0&&j>=0;i--,j--){
                if (checkNeg) {
                    if (board[i][j] != negColor) {
                        break;
                    }
                    else{
                        checkNeg = false;
                    }
                }
                else{
                    if(board[i][j] == color)return true;
                    else if(board[i][i]=='.')break;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new char[][]{{'.','.','B','B','B','.','B','B'},
                        {'.','W','B','.','W','B','B','B'},
                        {'.','W','.','W','B','.','.','W'},
                        {'B','B','B','W','.','W','W','W'},
                        {'.','B','W','W','B','W','B','B'},
                        {'.','B','.','.','B','W','W','W'},
                        {'B','B','.','B','B','W','B','.'},
                        {'W','.','.','W','B','B','W','B'}}
                ,7,2,'W'
        );
    }
}

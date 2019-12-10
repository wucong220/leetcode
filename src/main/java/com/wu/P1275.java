package main.java.com.wu;

/**
 * @author wuc006
 * @date 2019/12/10 11:45
 */
public class P1275 {
    class Solution {
        public String tictactoe(int[][] moves) {
            String[][] board =  new String[3][3];
            boolean flag=true;
            for(int[] move: moves){
                if(flag)board[move[0]][move[1]]="X";
                else board[move[0]][move[1]]="O";
                flag=!flag;
            }
            for(int i=0;i<3;i++){
                if(board[i][0]=="X"&&
                        board[i][1]=="X"&&board[i][2]=="X")return "A";
                if(board[i][0]=="O"&&
                        board[i][1]=="O"&&board[i][2]=="O")return"B";
                if(board[0][i]=="X"&&
                        board[1][i]=="X"&&board[2][i]=="X")return "A";
                if(board[0][i]=="O"&&
                        board[1][i]=="O"&&board[2][i]=="O")return"B";
            }
            if(board[0][0]=="X"&&
                    board[1][1]=="X"&&board[2][2]=="X")return "A";
            if(board[0][0]=="O"&&
                    board[1][1]=="O"&&board[2][2]=="O")return"B";
            if(board[0][2]=="X"&&
                    board[1][1]=="X"&&board[2][0]=="X")return "A";
            if(board[0][2]=="O"&&
                    board[1][1]=="O"&&board[2][0]=="O")return"B";

            if(moves.length==9)return "Draw";


            return "Pending";
        }
    }

    public static void main(String[] args) {
        RunUtil.run();
    }
}

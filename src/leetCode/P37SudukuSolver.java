package leetCode;

import java.util.Arrays;

public class P37SudukuSolver {

	static public void solveSudoku(char[][] board) {
		boolean[][] hang = new boolean[9][10];
		boolean[][] lie = new boolean[9][10];
		boolean[][] ge = new boolean[9][10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!hang[i][board[i][j] - '0'] && !lie[j][board[i][j] - '0']
							&& !ge[i / 3 + (j / 3) * 3][board[i][j] - '0']) {
						hang[i][board[i][j] - '0'] = true;
						lie[j][board[i][j] - '0'] = true;
						ge[i / 3 + (j / 3) * 3][board[i][j] - '0'] = true;
					}
				}
			}
		}


		tryfill(board,hang,lie,ge);


	}
	
	static boolean tryfill(char[][] board,boolean[][] hang,boolean[][] lie,boolean[][] ge){
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for(int k = 1;k<=9;k++){
						if (!hang[i][k] && !lie[j][k]
								&& !ge[i / 3 + (j / 3) * 3][k]) {
							hang[i][k] = true;
							lie[j][k] = true;
							ge[i / 3 + (j / 3) * 3][k] = true;
							board[i][j]=(char) ('0'+k);
							if(tryfill(board,hang,lie,ge))return true;
							else {
								board[i][j]='.';
								hang[i][k] = false;
								lie[j][k] = false;
								ge[i / 3 + (j / 3) * 3][k] = false;
								if(k==9)return false;
							}
						}
						else{
							if(k==9)return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] board = new char[][]{
		 {'.','8','7','.','5','4','3','2','1'}
		,{'2','.','.','.','.','.','.','.','.'}
		,{'3','.','.','.','.','.','6','.','.'}
		,{'4','.','.','.','.','.','.','.','.'}
		,{'5','.','.','.','.','6','.','.','.'}
		,{'.','.','.','.','.','.','.','6','.'}
		,{'7','.','.','.','.','.','.','.','.'}
		,{'8','.','.','.','.','.','.','.','.'}
		,{'9','.','.','6','.','.','.','.','.'}};
		
		
		solveSudoku(board);
		for(int i=0;i<9;i++)
		System.out.println(Arrays.toString(board[i]));
	}
}

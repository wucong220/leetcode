package leetCode100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P130SurroundedRegions {
	public static void findWay(int i1, int j1, boolean[][] result, char[][] board) {

		boolean up = false;
		boolean down = false;
		;
		boolean left = false;
		boolean right = false;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i1, j1 });
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			int i = ij[0];
			int j = ij[1];

			if (i > 0 && (!result[i - 1][j]) && board[i - 1][j] == 'O') {
				result[i - 1][j] = true;
				q.offer(new int[] { i - 1, j });
			}
			if (i < board.length - 1 && (!result[i + 1][j]) && board[i + 1][j] == 'O') {
				result[i + 1][j] = true;
				q.offer(new int[] { i + 1, j });
			}
			if (j > 0 && (!result[i][j - 1]) && board[i][j - 1] == 'O') {
				result[i][j - 1] = true;
				q.offer(new int[] { i, j - 1 });
			}
			if (j < board[0].length - 1 && (!result[i][j + 1]) && board[i][j + 1] == 'O') {
				result[i][j + 1] = true;
				q.offer(new int[] { i, j + 1 });
			}

		}
	}

	public static void solve(char[][] board) {
		boolean[][] result = new boolean[board.length][board[0].length];
		// 上下兩行
		{
			int i = 0;
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O' && result[i][j] == false) {
					result[i][j] = true;
					findWay(i, j, result, board);
				}
			}
			i = board.length - 1;
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O' && result[i][j] == false) {
					result[i][j] = true;
					findWay(i, j, result, board);
				}
			}
		}
		{
			// 左右兩列
			for (int i = 0; i < board.length; i++) {
				int j = 0;
				{
					if (board[i][j] == 'O' && result[i][j] == false) {
						result[i][j] = true;
						findWay(i, j, result, board);
					}
				}
				j = 1;
				{
					if (board[i][j] == 'O' && result[i][j] == false) {
						result[i][j] = true;
						findWay(i, j, result, board);
					}
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O' && result[i][j] == false) {
					board[i][j] = 'X';
				}
			}
		}

	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'X' } };
		for (char[] b : board) {
			System.out.println(Arrays.toString(b));
		}
		solve(board);
		for (char[] b : board) {
			System.out.println(Arrays.toString(b));
		}
	}

}

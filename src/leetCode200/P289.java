package leetCode200;

public class P289 {
	public void gameOfLife(int[][] board) {
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				board[i][j] = doSomething(board, i, j, board[i][j]);
			}
		}
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				board[i][j] = board[i][j]>100?board[i][j]/10%10:board[i][j]; 
			}
		}
	}

	public int doSomething(int[][] board, int x, int y, int value) {
		int count = 0;
		if (!(x == 0 || y == 0)) {
			count += board[x - 1][y - 1]%10;
		}
		if (!(x == 0 || y == board[0].length - 1)) {
			count += board[x - 1][y + 1]%10;
		}
		if (!(x == board.length - 1 || y == 0)) {
			count += board[x + 1][y - 1]%10;
		}
		if (!(x == board.length - 1 || y == board[0].length - 1)) {
			count += board[x + 1][y + 1]%10;
		}
		if (x != 0) {
			count += board[x - 1][y]%10;
		}
		if (x != board.length - 1) {
			count += board[x + 1][y]%10;
		}
		if (y != 0) {
			count += board[x][y - 1]%10;
		}
		if (y != board[0].length - 1) {
			count += board[x][y + 1]%10;
		}
		if (value == 0) {
			if (count == 3)
				return 110;
			else
				return 0;
		}
		else{
			if(count==2||count==3)return 1;
			else return 101;
		}
	}
}

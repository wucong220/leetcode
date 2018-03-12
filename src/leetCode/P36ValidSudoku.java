package leetCode;

public class P36ValidSudoku {
	static    public boolean isValidSudoku(char[][] board) {
        boolean[][] hang = new boolean[9][10];
        boolean[][] lie = new boolean[9][10];
        boolean[][] ge = new boolean[9][10];
        for(int i=0;i<9;i++){
        	for(int j=0;j<9;j++){
        		if(board[i][j]!='.'){
        			System.out.println(board[i][j]-'0');
        			System.out.println(hang[i][board[i][j]-'0']);
        			System.out.println(lie[j][board[i][j]-'0']);
        			System.out.println(ge[i/3+(j/3)*3][board[i][j]-'0']);
        			if(!hang[i][board[i][j]-'0']&&!lie[j][board[i][j]-'0']&&!ge[i/3+(j/3)*3][board[i][j]-'0']){
        				hang[i][board[i][j]-'0'] = true;
        				lie[j][board[i][j]-'0'] = true;
        				ge[i/3+(j/3)*3][board[i][j]-'0'] = true;
        			}
        			else return false;
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
		
		
		
		System.out.println(isValidSudoku(board));
	}
}

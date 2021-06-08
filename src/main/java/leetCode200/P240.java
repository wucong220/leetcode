package leetCode200;

public class P240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, 0, 0, matrix.length-1, matrix[0].length-1, target);
    }
    public boolean searchMatrix(int[][] matrix,int x1,int y1,int x2,int y2,int target){
    	if(y2-y1+1<3||x2-x1<3){
    		for(int i=x1;i<=x2;i++){
    			for(int j=y1;j<=y2;j++){
    				if(matrix[i][j]==target)return true;
    			}
    		}
    		return false;
    	}
    	int midx = x1+(x2-x1)/2;
    	int midy = y1+(y2-y1)/2;
    	if(matrix[midx][midy]==target)return true;
    	else if(matrix[midx][midy]>target) return searchMatrix(matrix, x1, y1, midx, midy, target)||
    											  searchMatrix(matrix, midx+1, y1, x2, midy-1, target)||
    											  searchMatrix(matrix, x1, midy+1,midx-1,y2, target);
    	else return searchMatrix(matrix, midx, midy, x2, y2, target)||
				  searchMatrix(matrix, midx+1, y1, x2, midy-1, target)||
				  searchMatrix(matrix, x1, midy+1,midx-1,y2, target);
    }
    public static void main(String[] args) {
		String s = "[[1,   4,  7, 11, 15],[2,   5,  8, 12, 19],[3,   6,  9, 16, 22],[10, 13, 14, 17, 24],[18, 21, 23, 26, 30]]";
		System.out.println(s.replace("[", "{").replace("]", "}"));
    	int[][] input = new int[][]{{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
    	System.out.println(new P240().searchMatrix(input, 20));

	}
}

package leetCode;

import java.util.Arrays;

public class P73SetMatrixZeros {
	static public void setZero(int[][] matrix){
		boolean flag_cur =false;
		boolean flag_pre =false;
		boolean flag_pre_pre =false;
		
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix[i].length;j++){
				if(matrix[i][j]==0){
					flag_cur=true;
					int k=i-1;
					while(k>=0){
						matrix[k][j]=0;
						k--;
					}
				}
				if(i>0&&matrix[i-1][j]==0){
					matrix[i][j]=0;
				}
			}
			if(flag_pre_pre==true){
				Arrays.fill(matrix[i-2], 0);
			}
			flag_pre_pre=flag_pre;
			flag_pre=flag_cur;
			flag_cur=false;
		}
		if(flag_pre==true){
			Arrays.fill(matrix[matrix.length-2], 0);
		}
		if(flag_cur==true){
			Arrays.fill(matrix[matrix.length-1], 0);
		}
	}
	public static void main(String[] args) {
		int[][] fuck = new int[][]{{1},{0}};
	}
}

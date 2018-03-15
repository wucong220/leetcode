package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix {
	static public List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> ret = new ArrayList<>();
		if(matrix.length==0)return ret;
		
		int h = matrix.length;
		int w = matrix[0].length;
		boolean[][] matrix_used = new boolean[h][w];
		int i = 0;
		int j = 0;
		int direction = 0;
		// 0 →，1↓，2←，3，↑
		while(i<h&&j<w&&matrix_used[i][j]==false)  {

			ret.add( matrix[i][j]);
			matrix_used[i][j] = true;
			switch(direction)
			{
				case 0: {j++;
					if (j == w || matrix_used[i][j] == true) {
						direction = 1;
						j--;
						i++;
					}
				}
				break;
				case 1: {
					i++;
					if (i == h || matrix_used[i][j] == true) {
						direction = 2;
						i--;
						j--;
					}
				}
				break;
				case 2: {
					j--;
					if (j == -1 || matrix_used[i][j] == true) {
						direction = 3;
						j++;
						i--;
					} 
				}
				break;
				case 3: {
					i--;
					if (i == -1 || matrix_used[i][j] == true) {
						direction = 0;
						i++;
						j++;
					}
				}
				break;
			}

		}

		return ret;
	}
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiralOrder(matrix));
	}
}

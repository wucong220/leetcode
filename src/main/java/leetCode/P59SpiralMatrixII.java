package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P59SpiralMatrixII {
    static public int[][] generateMatrix(int n) {

		int[][] matrix = new int[n][n];
		//if(matrix.length==0)return ret;
		int count = 1;
		int h = n;
		int w = n;
		boolean[][] matrix_used = new boolean[h][w];
		int i = 0;
		int j = 0;
		int direction = 0;
		// 0 →，1↓，2←，3，↑
		while(i<h&&j<w&&matrix_used[i][j]==false)  {

			matrix[i][j]=count++;
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

		return matrix;
        
    }
    
    public static void main(String[] args) {
    	int[][] matrix = generateMatrix(3);
		for(int i = 0; i<3;i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}

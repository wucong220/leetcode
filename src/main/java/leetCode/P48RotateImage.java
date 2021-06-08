package leetCode;

import java.util.Arrays;

/*You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. */
public class P48RotateImage {
	static public void rotate(int[][] matrix) {
		int c = matrix[0].length;
		for (int j = 0; j < c / 2; j++) {
			int s = j;
			int l = c-j*2;
			for (int i = 0; i < l-1; i++) {
				int temp = matrix[s][s+i];
				matrix[s][s+i] = matrix[s+l - 1 - i][s];
				matrix[s+l - 1 - i][s] = matrix[s + l - 1][s+l - 1 - i];
				matrix[s +l - 1][s + l - 1 - i] = matrix[s + i][s + l - 1];
				matrix[s+i][s + l - 1] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotate(input);
		for (int i = 0; i < 4; i++)
			System.out.println(Arrays.toString(input[i]));
	}
}

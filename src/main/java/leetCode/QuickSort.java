package leetCode;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] input, int start, int end) {
		if (start < end) {
			int i = start;
			int j = end;
			int key = input[start];
			while (i < j) {
				while (input[j] >= key && i < j)
					j--;
				input[i] = input[j];
				while (input[i] <= key && i < j)
					i++;
				input[j] = input[i];
			}
			input[i] = key;
			quickSort(input, start, i - 1);
			quickSort(input, i + 1, end);
		}
	}
	public static void main(String[] args) {
		int[] fucks    = new int[]{(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100)};
		System.out.println(Arrays.toString(fucks));
		quickSort(fucks,0,fucks.length-1);
		System.out.println(Arrays.toString(fucks));
		
	}
}

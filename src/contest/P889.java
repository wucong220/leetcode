package contest;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class P889 {
	public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
		Deque<int[]> ret = new LinkedList<>();
		int index = 1;
		int[] direction = { 0, 1 };
		int step = 1;
		ret.add(new int[]{r0,c0});
		int stepctr = 0;
		while (index < R * C) {
			int is[] = new int[2];
			ret.add(new int[]{(is[0]=ret.getLast()[0]+direction[0]),(is[1]=ret.getLast()[1]+direction[1])});
			if(!(is[0] < 0 || is[0] >= R || is[1] < 0 || is[1] >= C))index++;
			stepctr++;
			if (stepctr == step) {
				if (direction[1] < 0) {
					direction[0] = -1;
					direction[1] = 0;
				} else if (direction[1] > 0) {
					direction[0] = 1;
					direction[1] = 0;
				} else if (direction[0] < 0) {
					direction[0] = 0;
					direction[1] = 1;
					step++;
				} else if (direction[0] > 0) {
					direction[0] = 0;
					direction[1] = -1;
					step++;
				}
				stepctr=0;
			}
		}
		for (Iterator iterator = ret.iterator(); iterator.hasNext();) {
			int[] is = (int[]) iterator.next();
			if(is[0] < 0 || is[0] >= R || is[1] < 0 || is[1] >= C){
				iterator.remove();
			}
		}
		int[][] res = new int[ret.size()][2];
		int c=0;
		for (int[] i : ret) {
			res[c][0]=i[0];
			res[c++][1]=i[1];
		}
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new P889().spiralMatrixIII(5, 6, 1, 4)));
	}
}

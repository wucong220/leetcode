package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P84LargestRectangleInHistogram_TLE {
	static public int largestRectangleArea(int[] heights) {
		int max = 0;
		boolean flag = false;
		for (int height : heights) {
			if (height > max)
				max = height;
		}
		int maxv = 0;
		int old_width=0;
		List<int[]> rectangles = new ArrayList<>();
		
		for (int i = 0; i < heights.length; i++) {
			if (rectangles.size()==0&&heights[i]>0) {
				rectangles.add(new int[] { 1, heights[i] });
				maxv = Math.max(maxv,heights[i]);
			}else{
			for( Iterator<int[]> ii = rectangles.iterator();ii.hasNext();){
				int[] rectangle = ii.next();
				int w = rectangle[0];
				int h = rectangle[1];
				if(heights[i]<=h){
					old_width=w;
					ii.remove();	
				}
				else{
					rectangle[0]++;
					maxv = Math.max(maxv, (w+1)*h);
				}
			}
			if(heights[i]>0){
				rectangles.add(0, new int[]{old_width+1,heights[i]});
				maxv = Math.max(maxv,  (old_width+1)*heights[i]);
			}
			old_width=0;
			}
			
		}
		return maxv;
	}

	public static void main(String[] args) {
		System.out.println(largestRectangleArea(new int[] { 2,0,1,0,1,0 }));
	}
}

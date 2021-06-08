package leetCode;

import java.util.Stack;

public class P84LargestRectangleInHistogram {
	static public int largestRectangleArea(int[] heights) {
		//维护两个栈，一个装position，一个装size
		Stack<Integer> position = new Stack<>();
		Stack<Integer> size = new Stack<>();
		int max = 0;
		int s_top;
		int p_top = 0;
		for(int i=0;i<heights.length;i++){
			if(size.empty()||heights[i]>size.peek()){
				size.push(heights[i]);
				position.push(i);
			}
			else
			{
				if(heights[i]<=size.peek()){
					while(!size.empty()&&heights[i]<=size.peek()){
						p_top=position.pop();
						max = Math.max(max,size.pop()*(i-p_top));
					}
					position.push(p_top);
					size.push(heights[i]);
				}
			}
		}
		
		while(!size.empty()){
			s_top=size.pop();
			p_top=position.pop();
			max= Math.max(max, s_top*(heights.length-p_top));	
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		//https://www.youtube.com/watch?v=VNbkzsnllsU
		System.out.println(largestRectangleArea(new int[] { 2,1,5,6,2,3 }));
		
	}
}

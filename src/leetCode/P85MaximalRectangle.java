package leetCode;

import java.util.Arrays;
import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class P85MaximalRectangle {
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
	
    static public int maximalRectangle(char[][] matrix) {
        int width = matrix[0].length;
    	int[] dj = new int[width];
    	int max=0;
    	for(char[] row:matrix){
    		for(int i=0;i<width;i++){
    			if(row[i]!='0')dj[i]=dj[i]+1; else dj[i] = 0;
    			System.out.println(Arrays.toString(dj));
    		}
    		max = Math.max(largestRectangleArea(dj), max);	
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
		char[][] fuck = new char[][]{{'0','1'},{'1','0'}};//{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(maximalRectangle(fuck));
    }
}

package leetCode;

import java.util.Stack;

public class P42TrappingRainWater_ {
	static public int trap1(int[] height) {
		int old = 0;
		int ret = 0;
		int flag = 0;
		int count = 0;



		for (int i = 1;; i++) {
			for (int j = 0; j < height.length; j++) {
				if (height[j] >= i) {
					if (flag == 1) {
						ret = ret + j - old - 1;
					}
					old = j;
					flag = 1;
					count++;
				}
			}
			if(count<2){
				break;
			}
			count=0;
			old=0;
			flag=0;
		}

		return ret;
	}

	static public int trap(int[] height){
	    int ans = 0, current = 0;
	    Stack<Integer> st = new Stack<>();
	    while (current < height.length) {
	        while (!st.empty() && height[current] > height[st.peek()]) {
	            int top = st.peek();
	            st.pop();
	            if (st.empty()) //没有左壁
	                break;
	            int distance = current - st.peek() - 1;
	            int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
	            ans += distance * bounded_height;
	        }
	        st.push(current++);
	    }
	    return ans;
	}
	public static void main(String[] args) {
		int[] bars = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(bars));
	}
}

package com.wu;

import java.util.LinkedList;

public class CN17_21 {
    class Solution {
        public int trap(int[] height) {
            LinkedList<Integer> stack = new LinkedList<>();
            int ret = 0;
            for(int i=0;i<height.length;i++){
                if(stack.isEmpty())stack.push(i);
                else{
                    int old = 0;
                    int top  = stack.peek();
                    while(!stack.isEmpty()&&height[(top  = stack.peek())]<=height[i]){
                        ret += (i-top -1)*(height[top]-old);
                        old = height[top];
                        stack.pop();
                    }
                    if(!stack.isEmpty()){
                        ret+=(i-top-1)*(height[i]-old);
                    }
                    stack.push(i);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args)
    {
        RunUtil.run(RunUtil.toArray("[0,1,0,2,1,0,1,3,2,1,2,1]"));
    }
}

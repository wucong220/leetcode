package com.wu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/4/23 16:36
 */
public class CN42 {
    class Solution {
        public int trap(int[] height) {
            LinkedList<Integer> stack = new LinkedList<>();
            int total=0;
            for(int i=0;i<height.length;i++){
                if(stack.size()==0)stack.push(i);
                else{
                    Integer peek = stack.peek();
                    if(height[i]<height[peek]){
                        stack.push(i);
                    }
                    else{
                        LinkedList<Integer> cache = new LinkedList<>();
                        while(!stack.isEmpty()&&height[stack.peek()]<=height[i]){
                            Integer pop = stack.pop();
                            cache.offer(pop);
                        }
                        int down=0;
                        while(!cache.isEmpty()){
                            Integer pop = cache.poll();
                            total+=(height[pop]-down)*(i-pop-1);
                            down = height[pop];
                        }
                        if(!stack.isEmpty()){
                            Integer peek1 = stack.peek();
                            total+=(height[i]-down)*(i-peek1-1);
                        }
                        stack.push(i);
                    }
                }
            }

            return total;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray(
                "[0,1,0,2,1,0,1,3,2,1,2,1]"));
    }
}

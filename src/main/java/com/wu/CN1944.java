package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/8/3 17:43
 */
public class CN1944 {
    class Solution {


        public int[] canSeePersonsCount(int[] heights) {
            List<Integer> declineMonoStack = new ArrayList<>();
            int top = -1;
            int[] ret = new int[heights.length];
            for(int i=heights.length-1;i>=0;i--){
                int curr = heights[i];

                int l = 0;
                int r = declineMonoStack.size();
                while(l<r){
                    int m = l + (r - l)/2;
                    if(declineMonoStack.get(m)<curr){
                        r = m;
                    }
                    else{
                        l = m + 1;
                    }
                }
                ret[i] = Math.min(declineMonoStack.size()-l+1,declineMonoStack.size());
                if(declineMonoStack.isEmpty()){
                    declineMonoStack.add(curr);
                }
                else{
                    while(!declineMonoStack.isEmpty()&&declineMonoStack.get(declineMonoStack.size()-1)<=curr){
                        declineMonoStack.remove(declineMonoStack.size()-1);
                    }
                    declineMonoStack.add(curr);
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Object run = RunUtil.run(RunUtil.toArray("[5,1,2,3,10]"));
        System.out.println(Arrays.toString((int[]) run));
    }
}

package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/5/20 14:29
 */
public class CN135 {
    class Solution {
        public int candy(int[] ratings) {
            int[] left= new int[ratings.length];
            Arrays.fill(left,1);
            for(int i=1;i<ratings.length;i++){
                if(ratings[i]>ratings[i-1]){
                    left[i] = left[i-1]+1;
                }
            }

            int[] right = new int[ratings.length];
            Arrays.fill(right,1);
            for(int i=ratings.length-1;i>=0;i--){
                if(i<ratings.length-1){
                    if(ratings[i+1]<ratings[i]){
                        right[i] = right[i+1]+1;
                    }
                }
                right[i] = Math.max(right[i],left[i]);
            }
            return Arrays.stream(right).reduce(Integer::sum).getAsInt();
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,0,2]"));
    }
}

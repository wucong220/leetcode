package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/2/23 17:37
 */
public class CN1111 {
    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int[] depth = new int[seq.length()];

            int maxDepth = 0;
            for(int i=0;i<seq.length();i++){
                if(i==0)depth[i]=0;
                else {
                    if (seq.charAt(i) == '('){
                        depth[i]=depth[i-1]+1;
                    }
                    else{
                        depth[i] = depth[i-1]-1;
                    }
                }
                maxDepth = Math.max(maxDepth,depth[i]);
            }
            for(int i=0;i<seq.length();i++){
                if (seq.charAt(i) == ')'){
                    depth[i]=depth[i]+1;
                }
            }
            System.out.println(Arrays.toString(depth));
            int gap = maxDepth/2;
            int[] ret = new int[seq.length()];
            for(int i=0;i<ret.length;i++){
                if(depth[i]<=gap){
                    ret[i] = 0;
                }
                else{
                    ret[i] = 1;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("(()())");
    }
}

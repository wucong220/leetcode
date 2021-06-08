package com.wu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2021/3/4 9:16
 */
public class CN354 {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (a,b)->(a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]));
            int max = 0;
            int[] count = new int[envelopes.length];
            for(int i=0;i<envelopes.length;i++){
                count[i]=1;
                for(int j=0;j<i;j++){
                    if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]){
                        count[i] = Math.max(count[j]+1,count[i]);
                    }
                }
                max = Math.max(count[i],max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[4,5],[4,6],[6,7],[2,3],[1,1]]"));
    }
}

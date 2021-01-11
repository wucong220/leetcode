package com.wu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuc006
 * @date 2019/12/6 15:53
 */
public class P986 {
    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            List<int[]> list = new ArrayList<>();
            for(int i=0,j=0;i<A.length&&j<B.length;){
                int al=A[i][0],ar=A[i][1],bl=B[j][0],br=B[j][1];
                if(al>br){
                    j++;
                    continue;
                }
                if(ar<bl){
                    i++;
                    continue;
                }
                int leftBound= Math.max(al, bl);
                int rightBound = Math.min(ar, br);
                if(rightBound==ar){
                    i++;
                }
                else{
                    j++;
                }
                list.add(new int[]{leftBound, rightBound});
            }
            return list.toArray(new int[][]{});
        }
    }

    public static void main(String[] args) {
        int[][] A =  new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] B =  new int[][]{{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(new P986().new Solution().intervalIntersection(A,B)));
    }
}

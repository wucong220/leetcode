package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/3/15 9:18
 */
public class CN54 {
    int direction = 0; //0👉 1👇 2👈  3 👆
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ret = new ArrayList<>();
            int top = 0;
            int left = 0;
            int buttom = matrix.length-1;
            int right = matrix[0].length-1;
            while (top<=buttom&&left<=right){
                for(int y=left;y<=right;y++){
                    ret.add(matrix[top][y]);
                }

                for(int x=top+1;x<=buttom;x++){
                    ret.add(matrix[x][right]);
                }

                if(left<right&&top<buttom) {
                    for (int y = right - 1; y >= left; y--) {
                        ret.add(matrix[buttom][y]);
                    }

                    for (int x = buttom - 1; x > top; x--) {
                        ret.add(matrix[x][left]);
                    }
                }
                top++;
                left++;
                buttom--;
                right--;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[[1,2,3],[4,5,6],[7,8,9]]"));
    }
}

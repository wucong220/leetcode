package com.wu;

/**
 * @author wuc006
 * @date 2020/4/24 15:09
 */
public class P1401 {
    class Solution {
        public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
            int leftSquare;
            if(x_center<x1){
                leftSquare = (x1-x_center)*(x1-x_center);
            }
            else if(x_center>x2){
                leftSquare = (x2-x_center)*(x2-x_center);
            }
            else{
                leftSquare=0;
            }
            int rightSquare;
            if(y_center<y1){
                rightSquare = (y1-y_center)*(y1-y_center);
            }
            else if(y_center>y2){
                rightSquare = (y2-y_center)*(y2-y_center);
            }
            else{
                rightSquare=0;
            }

            return  leftSquare+rightSquare<=(radius*radius);
        }
    }

    public static void main(String[] args) {
        RunUtil.run(1,0,0,1,-1,3,1);
    }
}

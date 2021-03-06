package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/1/25 14:21
 */
public class CN959 {
    class Solution {
        int count=1;
        public int regionsBySlashes(String[] grid) {
            int[][] left_temp = new int[grid.length][grid[0].length()];
            int[][] right_temp = new int[grid.length][grid[0].length()];

            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length();j++){
                    left_temp[i][j]=-1;
                    right_temp[i][j]=-1;
                }
            }
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length();j++){
                    if(left_temp[i][j]==-1||right_temp[i][j]==-1) {
                        expand(grid, left_temp, right_temp, i, j, '全');
                        count++;
                    }
                }
            }
            return count-1;
        }

        public void expand(String[] grid,int[][] left_temp,int[][] right_temp,int i,int j,char pre){
            if(i<0||i>grid.length-1||j<0||j>grid[0].length()-1)return;
            else if(grid[i].charAt(j)==' '){
                if(left_temp[i][j]==-1&&right_temp[i][j]==-1) {
                    left_temp[i][j] = count;
                    right_temp[i][j] = count;
                    expand(grid, left_temp, right_temp, i + 1, j, '上');
                    expand(grid, left_temp, right_temp, i - 1, j, '下');
                    expand(grid, left_temp, right_temp, i, j + 1, '左');
                    expand(grid, left_temp, right_temp, i, j - 1, '右');
                }
            }
            else if(grid[i].charAt(j)=='/'){
                if(pre=='上'||pre=='左') {
                    if (left_temp[i][j] == -1) {
                        left_temp[i][j] = count;
                        expand(grid, left_temp, right_temp, i - 1, j, '下');
                        expand(grid, left_temp, right_temp, i, j - 1, '右');
                    }
                }
                else if ((pre=='下'||pre=='右')){
                    if(right_temp[i][j]==-1) {
                        right_temp[i][j] = count;
                        expand(grid, left_temp, right_temp, i + 1, j, '上');
                        expand(grid, left_temp, right_temp, i, j + 1, '左');
                    }
                }
                else if(left_temp[i][j]==-1&&right_temp[i][j]==-1){
                    left_temp[i][j]=count;
                    expand(grid,left_temp,right_temp,i-1,j,'下');
                    expand(grid,left_temp,right_temp,i,j-1,'右');
                    if(right_temp[i][j]==-1) {
                        right_temp[i][j] = ++count;
                        expand(grid, left_temp, right_temp, i + 1, j, '上');
                        expand(grid, left_temp, right_temp, i, j + 1, '左');
                    }
                }
                else if(left_temp[i][j]==-1){
                    left_temp[i][j]=count;
                    expand(grid,left_temp,right_temp,i-1,j,'下');
                    expand(grid,left_temp,right_temp,i,j-1,'右');
                }
                else if(right_temp[i][j]==-1){
                    right_temp[i][j]=count;
                    expand(grid,left_temp,right_temp,i+1,j,'上');
                    expand(grid,left_temp,right_temp,i,j+1,'左');
                }
            }
            else{
                if((pre=='下'||pre=='左')){
                    if(left_temp[i][j]==-1) {
                        left_temp[i][j] = count;
                        expand(grid, left_temp, right_temp, i + 1, j, '上');
                        expand(grid, left_temp, right_temp, i, j - 1, '右');
                    }
                }
                else if ((pre=='上'||pre=='右')){
                    if(right_temp[i][j]==-1) {
                        right_temp[i][j] = count;
                        expand(grid, left_temp, right_temp, i - 1, j, '下');
                        expand(grid, left_temp, right_temp, i, j + 1, '左');
                    }
                }
                else if(left_temp[i][j]==-1&&right_temp[i][j]==-1){
                    left_temp[i][j]=count;
                    expand(grid,left_temp,right_temp,i+1,j,'上');
                    expand(grid,left_temp,right_temp,i,j-1,'右');
                    if(right_temp[i][j]==-1) {
                        right_temp[i][j] = ++count;
                        expand(grid, left_temp, right_temp, i - 1, j, '下');
                        expand(grid, left_temp, right_temp, i, j + 1, '左');
                    }
                }
                else if(left_temp[i][j]==-1){
                    left_temp[i][j]=count;
                    expand(grid,left_temp,right_temp,i+1,j,'上');
                    expand(grid,left_temp,right_temp,i,j-1,'右');
                }
                else if(right_temp[i][j]==-1){
                    right_temp[i][j]=count;
                    expand(grid,left_temp,right_temp,i-1,j,'下');
                    expand(grid,left_temp,right_temp,i,j+1,'左');
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run((Object) new String[]{"\\/","/\\"});
    }
}

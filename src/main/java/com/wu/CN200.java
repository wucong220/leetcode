package com.wu;

/**
 * @author wuc006
 * @date 2021/5/7 10:31
 */
public class CN200 {
    class Solution {
        public int numIslands(char[][] grid) {
            int ret = 0;
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j]=='1'){
                        ret++;
                        destroy(grid,i,j);
                    }
                }
            }
            return ret;
        }

        private void destroy(char[][] grid, int i, int j) {
            if(i<0||j<0||i>grid.length-1||j>grid[0].length-1)return;
            if(grid[i][j]!='1')return;
            grid[i][j]='0';
            destroy(grid,i-1,j);
            destroy(grid,i+1,j);
            destroy(grid,i,j-1);
            destroy(grid,i,j+1);
        }
    }
}

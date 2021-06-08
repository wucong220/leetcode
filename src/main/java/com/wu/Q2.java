package com.wu;

/**
 * @author wuc006
 * @date 2021/4/5 15:36
 */
public class Q2 {
    class Solution {
        public int orchestraLayout(int num, int xPos, int yPos) {
            int[][] nums = new int[num][num];
            int d = 0;
            int x = 0;
            int y =0;
            int ctr = 1;
            while(true){
                if(x==xPos&&y==yPos)return ctr;
                nums[x][y]=ctr++;

                if(d==0){
                    if(y<nums[x].length&&nums[x][y+1]==0){
                        y++;
                    }
                    else{
                        d=1;
                        if(nums[x+1][y]==0) {
                            x++;
                        }
                        else{
                            break;
                        }
                    }
                }
                else if(d==1){
                    if(x<nums.length&&nums[x+1][y]==0){
                        x++;
                    }
                    else {
                        d=2;
                        if(nums[x][y-1]==0){
                            y--;
                        }
                        else{
                            break;
                        }
                    }
                }
                else if(d==2){
                    if(y>0&&nums[x][y-1]==0){
                        y--;
                    }
                    else{
                        d=3;
                        if(nums[x-1][y]==0){
                            y--;
                        }
                        else{
                            break;
                        }
                    }
                }
                else if(d==3){
                    if(x>0&&nums[x-1][y]==0){
                        x--;
                    }
                    else {
                        d=0;
                        if(y<nums[0].length&&nums[x][y+1]==0){
                            y++;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            return 0;
        }
    }
}

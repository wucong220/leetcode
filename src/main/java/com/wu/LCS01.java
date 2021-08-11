package com.wu;

/**
 * @author wuc006
 * @date 2021/6/21 10:29
 */
public class LCS01 {
    class Solution {
        public int leastMinutes(int n) {
            return leastMinutes(1,n);
        }

        public int leastMinutes(int width,int left){
            if(left<=0)return 0;
            if(width>=left)return 1;
            return leastMinutes(width*2,left)+1;
        }
    }
}

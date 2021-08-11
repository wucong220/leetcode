package com.wu;

/**
 * @author wuc006
 * @date 2021/8/7 11:34
 */
public class CN1954 {
    class Solution {
        public long minimumPerimeter(long neededApples) {
            //0-12-48-108
            long l = 0;
            long r = 100000;
            while(l<r){
                long m = l + (r - l)/2L;
                if(2L*m*(m+1L)*(2L*m+1L)>=neededApples){
                    r = m;
                }
                else{
                    l = m + 1L;
                }
            }
            long c = l*2L+1L;
            return c*4L-4;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(2784381467700L);
    }
}

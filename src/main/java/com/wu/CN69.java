package com.wu;

/**
 * @author wuc006
 * @date 2021/5/7 17:50
 */
public class CN69 {
    class Solution {
        public int mySqrt(int x) {
            long l=0L;
            long r=x+1L;
            while(l<r){
                long m = l + (r-l)/2L;
                if(m*m>x){
                    r=m;
                }
                else{
                    l=m+1L;
                }
            }
            return (int)(l-1L);
        }
    }
}

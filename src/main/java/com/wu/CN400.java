package com.wu;

/**
 * @author wuc006
 * @date 2021/6/21 9:17
 */
public class CN400 {
    class Solution {
        public int findNthDigit(int n) {
            //1-9,10-99,100-999,1000-9999,100000-99999
            //1-9,10-180,181-2880,,
            int base = 1;
            long pre = 0;
            for(int i=1;;i++){
                long ctr = base * 9;
                long lower = pre+1;
                long higher = lower+ctr*i-1;
                if(n<=higher){
                    long offset = n-lower;
                    long realNumberOffset = offset/i;
                    long realNumber = base + realNumberOffset;
                    char c = Long.toString(realNumber).charAt((int) (offset % i));
                    return c-'0';
                }
                base=base*10;
                pre = higher;
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run(1000000000);
    }
}

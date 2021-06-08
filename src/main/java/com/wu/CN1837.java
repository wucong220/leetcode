package com.wu;

/**
 * @author wuc006
 * @date 2021/4/27 15:14
 */
public class CN1837 {
    class Solution {
        public int sumBase(int n, int k) {
            int ret = 0;
            while(n>0){
                ret+=n%k;
                n=n/k;
            }
            return ret;
        }
    }
}

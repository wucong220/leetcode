package com.wu;

/**
 * @author wuc006
 * @date 2021/8/6 17:14
 */
public class CN1952 {
    class Solution {
        public boolean isThree(int n) {
            int ctr=0;
            for(int i=1;i<n;i++){
                if(n%i==0)ctr++;
            }
            return ctr==1;
        }
    }
}

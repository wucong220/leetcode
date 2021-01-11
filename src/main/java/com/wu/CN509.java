package com.wu;

/**
 * @author wuc006
 * @date 2021/1/4 16:53
 */
public class CN509 {
    class Solution {
        public int fib(int n) {
            if(n==0)return 0;
            int d1=0;
            int d2=1;
            for(int i=2;i<=n;i++){
                d1 = d1+d2;
                d2 = d1^d2;
                d1 = d1^d2;
                d2 = d1^d2;
            }
            return d2;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(3);
    }
}

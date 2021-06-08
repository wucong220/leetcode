package com.wu;

public class CN263 {
    class Solution {
        public boolean isUgly(int n) {
            if(n<=0)return false;
            while(n>0){
                if(n%5==0)n=n/5;
                else if(n%3==0)n=n/3;
                else if(n%2==0)n=n/2;
                else{
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(6);
    }
}

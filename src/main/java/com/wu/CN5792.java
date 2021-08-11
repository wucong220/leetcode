package com.wu;

public class CN5792 {
    class Solution {
        public int countTriples(int n) {
            int ret =0;
            for(int i=1;i*i<=n*n;i++){
                ret+= countDoubles(i*i);
            }
            return ret;
        }

        private int countDoubles(int c2) {
            int ret=0;
            for(int i=1;i*i<c2;i++){
                int b2 = c2 - i * i;
                if(b2==i*i)continue;
                int l=1;
                int r=b2;
                while(l<=r){
                    int m  = l +(r-l)/2;
                    if(m*m==b2){
                        ret++;
                        break;
                    }
                    else if(m*m<b2){
                        l=m+1;
                    }
                    else{
                        r = m-1;
                    }
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.methodName="countTriples";
        RunUtil.run(10);
    }
}

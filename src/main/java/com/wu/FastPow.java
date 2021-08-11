package com.wu;

/**
 * @author wuc006
 * @date 2021/8/10 17:34
 */
public class FastPow {
    static double pow(int x,int n){
        boolean flag = false;
        long nn=n;
        if(n<0){
            nn = -nn;
            flag = true;
        }
        double ret = 1;
        for(;nn>0;nn>>=1){
            if((nn&1)>0){
                ret = ret*x;
            }
            x = x*x;
        }
        return flag?1d/ret:ret;
    }

    public static void main(String[] args) {
        double pow = pow(2, 10);
        System.out.println(pow);
    }
}

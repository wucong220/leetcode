package com.wu;

/**
 * @author wuc006
 * @date 2021/5/25 15:27
 */
public class CN1870 {
    class Solution {
        public int minSpeedOnTime(int[] dist, double hour) {
            int l = 0;
            int r = 10_000_000;
            while(l<r){
                int m = l + (r - l)/2;
                if(calc(dist,m)<=hour){
                    r = m;
                }
                else{
                    l = l + 1;
                }
            }
            return (l==10_000_000)?-1:l;
        }

        public double calc(int[] dist,int speed){
            double ret =0;
            for(int i=0;i<dist.length;i++){
                ret += (i==dist.length-1)?(dist[i] * 1.0 / speed):Math.ceil(dist[i] * 1.0 / speed);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,3,2]"),2.7);
    }
}

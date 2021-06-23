package com.wu;

public class CN5768 {
    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            long[] preSum = new long[chalk.length];
            long sum = 0;
            for(int i=0;i<chalk.length;i++){
                preSum[i] = (i==0L?0L:preSum[i-1])+chalk[i];
                sum+=chalk[i];
            }
            k= (int) (k%sum);
            int l = 0;
            int r = chalk.length;
            while(l<r){
                int m = l + (r-l)/2;
                if(preSum[m]>k){
                    r=m;
                }
                else {
                    l = m + 1;
                }
            }
            if(l==chalk.length)return 0;
            else return l;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[3,4,1,2]"),25);
    }
}

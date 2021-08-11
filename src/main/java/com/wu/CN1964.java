package com.wu;

public class CN1964 {
    class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
            int[] d = new int[obstacles.length];
            int len = 0;
            int[] ret = new int[obstacles.length];
            for(int i=0;i<obstacles.length;i++){
                int l = 0;
                int r = len;
                while(l<r){
                    int m = l + (r - l)/2;
                    if(d[m]>obstacles[i]){
                        r = m;
                    }
                    else{
                        l = m + 1;
                    }
                }
                ret[i] = l+1;
                d[l] = obstacles[i];
                if(l==len)len++;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[3,1,5,6,4,2]"));
    }
}

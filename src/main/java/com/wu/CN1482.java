package com.wu;

import java.util.*;

public class CN1482 {
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            int max = Integer.MIN_VALUE;
            for(int i=0;i<bloomDay.length;i++){
                max = Math.max(bloomDay[i],max);
            }
            int l = 0;
            int r = max+1;
            while(l<r){
                int mid = l + (r-l)/2;
                if(getCount(bloomDay,k,mid)>=m){
                    r=mid;
                }
                else{
                    l = mid+1;
                }
            }
            if(r == max+1)return -1;
            else return l;
        }

        private int getCount(int[] bloomDay, int k, int mid) {
            int l = -1;
            int r = -1;
            int ret = 0;
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i]>mid){
                    if(l!=-1&&r!=-1){
                        ret+=(r-l+1)/k;
                    }
                    l=-1;
                    r=-1;
                }
                else{
                    if(l==-1)l=i;
                    r=i;
                }
            }
            if(l!=-1&&r!=-1){
                ret+=(r-l+1)/k;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[1,10,3,10,2]"),3,1);
    }
}

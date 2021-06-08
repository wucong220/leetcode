package com.wu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/5/19 17:00
 */
public class CN440 {
    class Solution {

        private int getCounts(int prefix,int max){
            long curr = prefix;
            long next = prefix+1;
            int ctr = 0;
            while(curr<=max){
                ctr += Math.min(next,max+1)-curr;
                curr *= 10;
                next *= 10;
            }
            return ctr;
        }

        public int findKthNumber(int n, int k) {
            int curr = 1;
            k = k -1;
            while(k>0){
                int counts = getCounts(curr, n);
                if(counts<=k){
                    k-=counts;
                    curr+=1;
                }
                else{
                    k-=1;
                    curr*=10;
                }
            }
            return curr;
        }
    }

    public static void main(String[] args) {
        RunUtil.methodName = "findKthNumber";
        RunUtil.run(13,2);
    }
}

package com.wu;
import java.util.*;

/**
 * @author wuc006
 * @date 2020/4/21 14:40
 */
public class P1414 {
    class Solution {
        public int findMinFibonacciNumbers(int k) {
            List<Integer> fibs = new ArrayList<>();
            Map<String,Integer> memo = new HashMap<>();
            int fibN_1=1;
            int fibN_2=1;
            int fibN = 0;
            fibs.add(fibN_1);
            fibs.add(fibN_2);
            for(int i=0;fibN<=k;i++){
                fibN = fibN_1+fibN_2;
                fibN_1 = fibN_2;
                fibN_2 = fibN;
                if(fibN<=k)
                fibs.add(fibN);
            }
            List<Integer> fibPreSum = new ArrayList<>();
            for(int i=0;i<fibs.size();i++){
                fibPreSum.add((i>0?fibPreSum.get(i-1):0)+fibs.get(i));
            }
            return dp(k,fibs.size(),fibs,fibPreSum,memo);
        }
        public int dp(int k,int n,List<Integer> fibs,List<Integer> fibPreSum,Map<String,Integer> memo){
            if(memo.containsKey(k+" "+n)){
                return memo.get(k+" "+n);
            }
            if(k==0)return 0;
            if(k<0||n==0)return Integer.MAX_VALUE/2;
            if(k>fibPreSum.get(n-1))return  Integer.MAX_VALUE/2;
            if(k==1&&fibs.get(n-1)==k)return 1;
            int min = Math.min(dp(k - fibs.get(n - 1), n - 1, fibs, fibPreSum, memo) + 1, dp(k, n - 1, fibs, fibPreSum, memo));
            memo.put(k+" "+n,min);
            return min;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P1414().new Solution().findMinFibonacciNumbers(9083494));
        System.out.println(new P1414().new Solution().findMinFibonacciNumbers(10));
        System.out.println(new P1414().new Solution().findMinFibonacciNumbers(19));
    }
}

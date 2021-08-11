package com.wu;

public class CN5823 {
    class Solution {
        public int getLucky(String s, int k) {
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum+=getSum(c-'a'+1);
            }
            for(int i=1;i<k;i++){
                sum=getSum(sum);
            }
            return sum;
        }

        private int getSum(int a){
            int temp = a;
            int newSum = 0;
            while(temp>0){
                newSum+=temp%10;
                temp = temp/10;
            }
            return newSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(RunUtil.run("leetcode",
                2));
    }
}

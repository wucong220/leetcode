package com.wu;

/**
 * @author wuc006
 * @date 2020/4/28 9:05
 */
public class P1422 {
    class Solution {
        public int maxScore(String s) {
            char[] chars = s.toCharArray();
            int[] ones = new int[chars.length];
            int[] zeros = new int[chars.length];
            for(int i=0;i<s.length();i++){
                zeros[i] = (i==0?0:zeros[i-1])+('1'-chars[i]);
            }
            for(int i=s.length()-1;i>=0;i--){
                ones[i] = (i==(s.length()-1)?0:ones[i+1])+(chars[i]-'0');
            }
            int max = 0;
            for(int i=0;i<s.length();i++){
                if(i==0&&zeros[i]==0)continue;
                if(i==s.length()-1&&ones[i]==0)continue;
                if(zeros[i]+ones[i]>max){
                    max = zeros[i]+ones[i];
                }
            }
            return max;
        }
    }
    public static void main(String[] args) {

    }
}

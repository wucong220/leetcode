package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2020/5/14 11:08
 */
public class P1433 {
    class Solution {
        public boolean checkIfCanBreak(String s1, String s2) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            boolean ret = false;
            boolean break1 = true;
            boolean break2 = true;
            for(int j=0;j<chars1.length;j++){
                if(chars1[j]-chars2[j]>0){
                    break1 = false;
                }
                if(chars1[j]-chars2[j]<0){
                    break2 = false;
                }
            }
            ret = ret|break1|break2;
            return ret;
        }

        //左移n位
        public void permutation(char[] input, int n) {
            n = n % input.length;
            reverse(input, 0, n);
            reverse(input, n + 1, input.length - 1);
            reverse(input, 0, input.length - 1);
        }

        public void reverse(char[] input, int l, int r) {
            while (l < r) {
                input[l] = (char) (input[l] ^ input[r]);
                input[r] = (char) (input[l] ^ input[r]);
                input[l] = (char) (input[l] ^ input[r]);
                l++;
                r--;
            }
        }
    }
    public static void main(String[] args) {
//        RunUtil.methodName="checkIfCanBreak";
//        RunUtil.params=new Class[]{String.class,String.class};
        RunUtil.run("yopumzgd", "pamntyya");
    }
}

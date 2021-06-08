package com.wu;

/**
 * @author wuc006
 * @date 2021/5/18 9:15
 */
public class CN1442 {
    class Solution {
        public int countTriplets(int[] arr) {
            int[] preXOR = new int[arr.length];
            for(int i=0;i<arr.length;i++){
                preXOR[i] = (i>0?preXOR[i-1]:0)^arr[i];
            }
            int ret = 0;
            for(int i=0;i<arr.length;i++){
                for(int j=i+1;j<arr.length;j++){
                    for(int k = j;k<arr.length;k++){
                        if(i==0&&preXOR[j-1]==(preXOR[k]^preXOR[j-1])){
                            ret++;
                        }
                        else if(i!=0&&(preXOR[j-1]^preXOR[i-1])==(preXOR[k]^preXOR[j-1])){
                            ret++;
                        }
                    }
                }
            }
            return ret;
        }
    }
}

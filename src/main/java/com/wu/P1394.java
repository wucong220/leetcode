package com.wu;

/**
 * @author wuc006
 * @date 2020/4/24 17:18
 */
public class P1394 {
    class Solution {
        public int findLucky(int[] arr) {
            int[] freq = new int[501];
            for(int i=0;i<arr.length;i++){
                freq[arr[i]]++;
            }
            int max = -1;
            for(int i=0;i<freq.length;i++){
                if(freq[i]>0&&freq[i]==i){
                     max = Math.max(freq[i],max);
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(new int[]{7,7,7,7,7,7,7});
    }
}

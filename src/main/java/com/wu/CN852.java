package com.wu;

/**
 * @author wuc006
 * @date 2021/6/15 10:56
 */
public class CN852 {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int l = -1;
            int r=arr.length;
            while(l<=r){
                int m = l + (r - l)/2;
                if((m==0||arr[m]>arr[m-1])&&(m==arr.length-1||arr[m]>arr[m+1])){
                    return m;
                }
                else if(m!=arr.length-1&&arr[m]<arr[m+1]){
                    r = m-1;
                }
                else{
                    l = m + 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[3,4,5,1]"));
    }
}

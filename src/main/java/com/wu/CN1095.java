package com.wu;

/**
 * @author wuc006
 * @date 2021/5/20 16:57
 */
public class CN1095 {
    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     *     public int get(int index) {}
     *     public int length() {}
     * }
     */

    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            int l = 0;
            int length = mountainArr.length();
            int r = length;
            while(l<r){
                int m = l + (r - l)/2;
                int mVal = mountainArr.get(m);
                if(m==length-1||mountainArr.get(m+1)<mVal||mVal>=target){
                    r = m;
                }
                else{
                    l = m+1;
                }
            }
            if(mountainArr.get(l)==target)return l;
            l = 0;
            r = length;
            while(l<r){
                int m = l + (r - l)/2;
                int mVal = mountainArr.get(m);
                if(m==length-1||(mountainArr.get(m+1)<mVal)&&mVal<=target){
                    r = m;
                }
                else{
                    l = m+1;
                }
            }
            if(mountainArr.get(l)==target)return l;
            return -1;
        }
    }
}

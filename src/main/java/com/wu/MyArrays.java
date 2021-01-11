package com.wu;

import java.util.Comparator;

/**
 * @author wuc006
 * @date 2021/1/7 15:08
 */
public class MyArrays {
    /**
     * 仿Arrays.binarySearch
     * @param array src
     * @param fromIndex inclusive
     * @param toIndex exclusive
     * @param key target
     * @param comparator
     * @return if(target in array) return index; else return -1 - insertPosition.
     * insertPosition is position of the least element whose value bigger than key
     * or array.length if all elements of array is smaller than key
     */
    static int binarySearch(int[] array, int fromIndex, int toIndex, int key, Comparator<Integer> comparator){
        int l = fromIndex;
        int r = toIndex;
        while(l<r){
            int m = l + (r-l)/2;
            if(comparator.compare(array[m],key)>=0){
                r = m;
            }
            else{
                l = m+1;
            }
        }
        if(array[l] == key)return l;
        else return -1-l;
    }
}

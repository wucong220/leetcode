package com.wu.sort;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/6/8 9:40
 */
public class QuickSort {
    static void sort(int[] array,int left, int right){
        if(left<right) {
            int target = array[left];
            int l = left;
            int r = right;
            while (l < r) {
                while (l < r && array[r] >= target) r--;
                if (l < r) array[l] = array[r];
                while (l < r && array[l] <= target) l++;
                if (l < r) array[r] = array[l];
            }
            array[l] = target;

            sort(array,left,l-1);
            sort(array,l+1,right);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,4};
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}

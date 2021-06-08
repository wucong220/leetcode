package com.wu.sort;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/6/8 10:23
 */
public class MergeSortIterate {
    static void sort(int[] a){
        for(int i=1;i<a.length;i*=2){
            for(int j=0;j<a.length;j+= 2 * i){
                int k = j;
                int l = j+i;
                int max = Math.min(2 * i,a.length-1);
                int[] temp = new int[max];
                int m=0;
                while(k<j+i&&l<j+ max){
                    if(a[k]<a[l]){
                        temp[m++] = a[k++];
                    }
                    else{
                        temp[m++] = a[l++];
                    }
                }

                while(k<j+i){
                    temp[m++] = a[k++];
                }

                while(l<j+ max){
                    temp[m++] = a[l++];
                }

                System.arraycopy(temp,0,a,j, max);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}

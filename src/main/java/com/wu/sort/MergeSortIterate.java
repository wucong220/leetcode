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
                int maxK = Math.min( i,a.length-j);
                int maxL = Math.min(2 * i,a.length-j);
                int[] temp = new int[maxL];
                int m=0;
                while(k<j+maxK&&l<j+ maxL){
                    if(a[k]<a[l]){
                        temp[m++] = a[k++];
                    }
                    else{
                        temp[m++] = a[l++];
                    }
                }

                while(k<j + maxK){
                    temp[m++] = a[k++];
                }

                while(l<j + maxL){
                    temp[m++] = a[l++];
                }

                System.arraycopy(temp,0,a,j, maxL);
            }
        }
    }

    public static void main(String[] args) {
        SortTest.run(MergeSortIterate::sort);
    }
}

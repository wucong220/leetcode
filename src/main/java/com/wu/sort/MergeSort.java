package com.wu.sort;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/6/8 9:54
 */
public class MergeSort {
    static void sort(int[] a,int l,int r){
        if(l==r) return;
        int mid = l + (r - l) / 2;
        sort(a,l, mid);
        sort(a,mid+1,r);
        merge(a,l,mid,r);
    }

    static void merge(int[] a,int l,int mid,int r){
        int[] temp=  new int[r-l+1];
        int k=0,i=l,j=mid+1;
        while(i<=mid&&j<=r){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }
            else{
                temp[k++] = a[j++];
            }
        }
        while(i<=mid){
            temp[k++] = a[i++];
        }
        while(j<=r){
            temp[k++] = a[j++];
        }
        System.arraycopy(temp,0,a,l,r-l+1);
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,2,4};
        sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}

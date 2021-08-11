package com.wu.sort;

/**
 * @author wuc006
 * @date 2021/6/9 18:08
 */
public class SelectSort {
    static void sort(int[] a){
        for(int i=0;i<a.length-1;i++){
            int minI=-1;
            int min=Integer.MAX_VALUE;
            for(int j=i;j<a.length;j++){
                if(a[j]<min){
                    min = a[j];
                    minI = j;
                }
            }
            int temp = a[i];
            a[i] = a[minI];
            a[minI] = temp;
        }
    }

    public static void main(String[] args) {
        SortTest.run(SelectSort::sort);
    }
}

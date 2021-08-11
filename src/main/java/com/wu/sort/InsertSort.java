package com.wu.sort;

/**
 * @author wuc006
 * @date 2021/6/9 18:02
 */
public class InsertSort {
    static void sort(int[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0;j--){
                if(a[j]<a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
                else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortTest.run(InsertSort::sort);
    }
}

package com.wu.sort;

/**
 * @author wuc006
 * @date 2021/6/9 17:57
 */
public class BubbleSort implements Sort{
    static void sort(int[] a){
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    int temp  = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    static void sort1(int[] a){
        for(int i=1;i<a.length;i++){
            boolean flag = false;
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    flag=true;
                    int temp  = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if(!flag)break;
        }
    }

    public static void main(String[] args) {
        SortTest.run(BubbleSort::sort1);
    }
}

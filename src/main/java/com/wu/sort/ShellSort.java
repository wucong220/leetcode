package com.wu.sort;

/**
 * @author wuc006
 * @date 2021/6/10 17:02
 */
public class ShellSort {
    static void sort(int[] a){
        for(int step = a.length/2;step>0;step = step/2){
            for(int i=step;i<a.length;i+=step){
                for(int j=i;j>0;j-=step){
                    if(a[j]<a[j-step]){
                        int temp = a[j];
                        a[j] = a[j-step];
                        a[j-step] = temp;
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SortTest.run(ShellSort::sort);
    }
}

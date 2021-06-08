package com.wu.sort;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

/**
 * @author wuc006
 * @date 2021/6/8 17:52
 */
public class HeapSort {
    static void sort(int[] a){
        buildHeap(a);
        for(int i=0;i<a.length;i++){
            int temp = a[0];
            a[0] = a[a.length-1-i] ;
            a[a.length-1-i] = a[0];
            shiftDown(a,a.length-1-i);
        }
    }

    private static void shiftDown(int[] a, int size) {
        int i=0;
        int target = a[0];
        while(i<size){
            if(a[i*2+1]<target){
                a[i] = a[i*2+1];
            }
//            if(a[i])
        }
    }

    private static void buildHeap(int[] a) {

    }
}

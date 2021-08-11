package com.wu.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author wuc006
 * @date 2021/6/8 17:52
 */
public class HeapSort {
    static void sort(int[] a){
        buildHeap(a);
        System.out.println(Arrays.toString(a));
        for(int i=0;i<a.length;i++){
            int temp = a[0];
            a[0] = a[a.length-1-i] ;
            a[a.length-1-i] = temp;
            shiftDown(a,a.length-1-i);
        }
    }

    private static void buildHeap(int[] a) {
        for(int i=1;i<a.length;i++){
            shiftUp(a,i);
        }
    }

    private static void shiftDown(int[] a, int size) {
        int i=0;
        int target = a[0];
        while(i<size){
            int leftChild = i * 2 + 1;
            int rightChild = i*2+2;

            if(rightChild<size&&a[rightChild]>target&&a[rightChild]>a[leftChild]){
                a[i] = a[rightChild];
                i = rightChild;
            }
            else if(leftChild<size&&a[leftChild]>target){
                a[i] = a[leftChild];
                i = leftChild;
            }
            else{
                a[i] = target;
                break;
            }
        }
    }

    private static void shiftUp(int[] a, int i) {
        int target = a[i];
        while(true){
            int parent = (i+1)/2-1;
            if(parent>=0&&a[parent]<target){
                a[i] = a[parent];
                i = parent;
            }
            else{
                a[i]  =target;
                break;
            }
        }
    }

    public static void main(String[] args) {
        SortTest.run(HeapSort::sort);
    }
}

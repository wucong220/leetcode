package com.wu.sort;

/**
 * @author wuc006
 * @date 2021/6/10 17:17
 */
public class RadixSort {
    static void lsd(int[] a){
        int maxDigit = getMaxDigit(a);
        int[][] buckets = new int[10][a.length];
        int[] ctr = new int[10];

        int pos = 1;

        for(int i=0;i<maxDigit;i++){
            for (int n : a) {
                int bucketIndex = n/pos%10;
                buckets[bucketIndex][ctr[bucketIndex]++]=n;
            }
            for(int j =0,m=0;j<10;j++){
                for(int k = 0;k<ctr[j];k++){
                    a[m++]=buckets[j][k];
                }
                ctr[j]=0;
            }
            pos*=10;
        }
    }

    static void msd(int[] a){
        int maxDigit = getMaxDigit(a);
        int pos = 1;
        for(int i=0;i<maxDigit-1;i++){
            pos*=10;
        }
        msd(a,a.length,pos);
    }

    static void msd(int[] a,int length,int pos){
        if(pos==0)return;
        int[][] buckets = new int[10][length];
        int[] ctr = new int[10];

        for (int i = 0; i < length; i++) {
            int n = a[i];
            int bucketIndex = n / pos % 10;
            buckets[bucketIndex][ctr[bucketIndex]++] = n;
        }
        for(int j =0,m=0;j<10;j++){
            if(ctr[j]>1){
                msd(buckets[j],ctr[j],pos/10);
            }
            for(int k = 0;k<ctr[j];k++){
                a[m++]=buckets[j][k];
            }
            ctr[j]=0;
        }
    }

    static int getMaxDigit(int[] a){
        int max = 0;
        for (int i : a) {
            int ctr = 0;
            while(i>0){
                i/=10;
                ctr++;
            }
            max = Math.max(ctr,max);
        }
        return max;
    }

    public static void main(String[] args) {
        SortTest.run(RadixSort::msd);
    }
}

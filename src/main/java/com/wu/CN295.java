package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/5/24 15:39
 */
public class CN295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        double median = medianFinder.findMedian();
        System.out.println(median);
    }
}
class MedianFinder {
    int[] bitTree = new int[101];
    int count=0;

    private void update(int x,int val){
        while(x<bitTree.length){
            bitTree[x] += val;
            x += Integer.lowestOneBit(x);
        }
    }

    private int query(int x){
        int ret = 0;
        while(x>0){
            ret+=bitTree[x];
            x -= Integer.lowestOneBit(x);
        }
        return ret;
    }

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(num<=100){
            update(num+1,1);
        }
        count++;
    }

    public double findMedian() {
        int countBeforeMedian = this.count / 2;
        if(this.count%2==0){
              return (1.0*find(countBeforeMedian + 1)+find(countBeforeMedian))/2;
        }
        else{
            return find(countBeforeMedian + 1);
        }
    }

    private int find(int count){
        int l=0;
        int r=101;
        while(l<r){
            int m = l + (r - l)/2;
            if(query(m+1)>=count){
                r = m;
            }
            else{
                l = m + 1;
            }
        }
        return r;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

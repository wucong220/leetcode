package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/1/7 14:51
 */
public class CN1713 {
    /**
     * it is the same question in 300
     */
    class Solution {
        public int minOperations(int[] target, int[] arr) {
            int tail = -1;
            int[] tails = new int[arr.length];
            Map<Integer,Integer> weight = new HashMap<>();
            for(int i=0;i<target.length;i++){
                weight.put(target[i],i);
            }
            for (int i = 0; i < arr.length; i++) {
                if(!weight.containsKey(arr[i]))continue;
                if(tail==-1){
                    tails[++tail]=arr[i];
                }
                else{
                    if(weight.get(tails[tail])<weight.get(arr[i])){
                        tails[++tail]=arr[i];
                    }
                    else{
                        int index = binarySearch(tails, 0, tail, arr[i], Comparator.comparingInt(weight::get));
                        if(index>-1) {
                            tails[index] = arr[i];
                        }
                        else{
                            tails[-(index+1)] = arr[i];
                        }
                    }
                }
            }
            return weight.size()-(tail+1);
        }

        int binarySearch(int[] array, int fromIndex, int toIndex, int key, Comparator<Integer> comparator){
            int l = fromIndex;
            int r = toIndex;
            while(l<r){
                int m = l + (r-l)/2;
                if(comparator.compare(array[m],key)>=0){
                    r = m;
                }
                else{
                    l = m+1;
                }
            }
            if(array[l] == key)return l;
            else return -1-l;
        }
    }
}

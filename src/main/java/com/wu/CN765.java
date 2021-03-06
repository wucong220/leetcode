package com.wu;

import java.util.HashMap;
import java.util.Map;

public class CN765 {
    class Solution {
        public int minSwapsCouples(int[] row) {
            Map<Integer,Integer> index = new HashMap<>();
            int count=0;
            for(int i=0;i<row.length;i++){
                index.put(row[i],i);
            }
            for(;;){
                if(trySwap1(row,index)){
                    count++;
                }
                if(trySwap2(row,index)){
                    count++;
                }
                else{
                    break;
                }
            }
            return count;
        }
        boolean trySwap1(int[] row,Map<Integer,Integer> index){
            for(int i=0;i<row.length;i++){
                int curr = row[i];
                int pair = findPair(curr);
                int pairIndex = index.get(pair);
                if(i%2==0){
                    if(pairIndex==i+1){
                        continue;
                    }
                    else{
                        //判断【当前的对象】和【对象的对象】是不是对象
                        int curr_next = row[i+1];
                        if(pairIndex%2==0){
                            int pair_next = row[pairIndex+1];
                            if(findPair(pair_next)==curr_next){
                                swap(row,i+1,pairIndex);
                                index.put(curr_next,pairIndex);
                                index.put(pair,i+1);
                                return true;
                            }
                        }
                        else{
                            int pair_pre = row[pairIndex-1];
                            if(findPair(pair_pre)==curr_next){
                                swap(row,i+1,pairIndex);
                                index.put(curr_next,pairIndex);
                                index.put(pair,i+1);
                                return true;
                            }
                        }
                    }
                }
                else {
                    if(pairIndex==i-1){
                        continue;
                    }
                    else{
                        int curr_pre = row[i-1];
                        if(pairIndex%2==0){
                            int pair_next = row[pairIndex+1];
                            if(findPair(pair_next)==curr_pre){
                                swap(row,i-1,pairIndex);
                                index.put(curr_pre,pairIndex);
                                index.put(pair,i-1);
                                return true;
                            }
                        }
                        else{
                            int pair_pre = row[pairIndex-1];
                            if(findPair(pair_pre)==curr_pre){
                                swap(row,i-1,pairIndex);
                                index.put(curr_pre,pairIndex);
                                index.put(pair,i-1);
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        boolean trySwap2(int[] row,Map<Integer,Integer> index){
            for(int i=0;i<row.length;i++){
                int curr = row[i];
                int pair = findPair(curr);
                int pairIndex = index.get(pair);
                if(i%2==0){
                    if(pairIndex==i+1){
                        continue;
                    }
                    else{
                        //判断【当前的对象】和【对象的对象】是不是对象
                        int curr_next = row[i+1];
                        if(pairIndex%2==0){
                            swap(row,i+1,pairIndex);
                            index.put(curr_next,pairIndex);
                            index.put(pair,i+1);
                            return true;
                        }
                        else{
                            swap(row,i+1,pairIndex);
                            index.put(curr_next,pairIndex);
                            index.put(pair,i+1);
                            return true;
                        }
                    }
                }
                else {
                    if(pairIndex==i-1){
                        continue;
                    }
                    else{
                        int curr_pre = row[i-1];
                        if(pairIndex%2==0){
                            swap(row,i-1,pairIndex);
                            index.put(curr_pre,pairIndex);
                            index.put(pair,i-1);
                            return true;
                        }
                        else{
                            swap(row,i-1,pairIndex);
                            index.put(curr_pre,pairIndex);
                            index.put(pair,i-1);
                            return true;
                        }
                    }
                }
            }
            return false;
        }


        public int findPair(int i){
            if(i%2==0){
                return i+1;
            }
            else return i-1;
        }

        public void swap(int[] row,int a,int b){
            int temp = row[a];
            row[a] = row[b];
            row[b] = temp;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[5,4,2,6,3,1,0,7]"));
    }
}

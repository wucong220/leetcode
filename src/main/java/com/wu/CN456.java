package com.wu;

import java.util.*;

public class CN456 {
    class Solution {
        public boolean find132pattern(int[] nums) {
            List<Integer> list = new ArrayList<>();
            Integer start = null;
            for(int i=0;i<nums.length;i++){
                if(i>0&&list.size()==0&&nums[i]>nums[i-1]){
                    list.add(nums[i-1]);
                    list.add(nums[i]);
                }
                else if(!list.isEmpty()){
                    if(nums[i]>list.get(list.size()-1)){
                        Integer integer = list.get(0);
                        list.clear();;
                        if(start==null) {
                            list.add(integer);
                        }
                        else {
                            list.add(start);
                            start = null;
                        }
                        list.add(nums[i]);
                    }
                    else if(nums[i]<list.get(0)){
                        if(start==null){
                            start = nums[i];
                        }
                        else{
                            if(start<nums[i]){
                                list.add(0,nums[i]);
                                list.add(0,start);
                                start = null;
                            }
                            else{
                                start = nums[i];
                            }
                        }
                    }
                    else{
                        int index = Collections.binarySearch(list, nums[i], (a, b) -> a - b);
                        if(index<0){
                            int insert = -index-1;
                            if(insert%2==1)return true;
                            else{
                                List<Integer> temp = new ArrayList<>();
                                if(start==null) {
                                    temp.add(list.get(0));
                                }
                                else{
                                    temp.add(start);
                                    start = null;
                                }
                                temp.add(nums[i]);
                                temp.addAll(list.subList(insert,list.size()));
                                list = temp;
                            }
                        }
                        else{
                            if(start!=null){
                                List<Integer> temp = new ArrayList<>();
                                temp.add(start);
                                if(index%2==0){
                                    temp.addAll(list.subList(index+1,list.size()));
                                }
                                else{
                                    temp.addAll(list.subList(index,list.size()));
                                }
                                list = temp;
                                start = null;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[25,35,15,35,20]"));
    }
}

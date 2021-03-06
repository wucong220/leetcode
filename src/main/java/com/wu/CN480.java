package com.wu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2021/2/3 9:36
 */
public class CN480 {
    class Solution {
//        class Node{
//            int val;
//            Node(int val){
//                this.val =val;
//            }
//        }

        public double[] medianSlidingWindow(int[] nums, int k) {
//            LinkedList<Node> list = new LinkedList<>();
//            for(int i=0;i<k;i++){
//                list.add(new Node(nums[i]));
//            }
            double[] ret = new double[nums.length-k+1];
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<k;i++){
                list.add(nums[i]);
            }
            list.sort(Comparator.comparingInt(a->a));
            ret[0] = getMedian(list);
            for(int i=1;i<=nums.length-k;i++){
                int indexRemove = Collections.binarySearch(list, nums[i - 1]);
                list.remove(indexRemove);
                int index = Collections.binarySearch(list, nums[i + k - 1]);
                if(index>=0)list.add(index,nums[i+k-1]);
                else list.add(-(index +1),nums[i+k-1]);
                ret[i] = getMedian(list);
            }
            System.out.println(Arrays.toString(ret));
            return ret;
        }

        double getMedian(List<Integer> list){
            if(list.size()%2==0){
                return (list.get(list.size() / 2)+0L + list.get(list.size() / 2 - 1)) * 1.0 / 2;
            }
            else{
                return list.get(list.size()/2);
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run((Object)RunUtil.toArray("[1,1,1,1]"),2);
    }
}

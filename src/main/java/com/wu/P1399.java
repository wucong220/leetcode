package com.wu;

import sun.reflect.generics.tree.Tree;

import java.util.PriorityQueue;
import java.util.TreeMap;
import  java.util.*;
/**
 * @author wuc006
 * @date 2020/4/24 14:16
 */
public class P1399 {
    class Solution {
        public int countLargestGroup(int n) {
            Map<Integer,List<Integer>> map = new HashMap<>();
            for(int i=1;i<=n;i++){
                int digitSum = getDigitSum(i);
                map.putIfAbsent(digitSum,new ArrayList<>());
                List<Integer> group = map.get(digitSum);
                group.add(i);
            }
            List<List<Integer>> a = new ArrayList<>(map.values());
            a.sort((g1,g2)->g2.size()-g1.size());
            int i = 0;
            for (; i < a.size(); i++) {
                if(i>0&&a.get(i).size()<a.get(i-1).size()) {
                    break;
                }
            }
            return i;
        }

        int getDigitSum(int n){
            int sum=0;
            while(n>0) {
                sum += n%10;
                n=n/10;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(13);
    }
}

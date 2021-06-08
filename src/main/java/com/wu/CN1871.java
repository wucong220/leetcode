package com.wu;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wuc006
 * @date 2021/5/25 15:44
 */
public class CN1871 {
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            TreeSet<int[]> set =new TreeSet<>(Comparator.comparing(a->a[0]));
            set.add(new int[]{Integer.MIN_VALUE,0});
            for (int i=0;i<s.length();i++){
                int[] floor = set.floor(new int[]{i, i});
                if(floor!=null&&floor[0]<=i&&floor[1]>=i&&s.charAt(i)=='0'){
                    int[] newInterval = {i + minJump, i + maxJump};
                    int[] floor1 = set.floor(newInterval);
                    if(floor1!=null&&floor1[1]>=newInterval[0]){
                        set.remove(floor1);
                        set.add(new int[]{floor1[0],newInterval[1]});
                    }
                    else{
                        set.add(newInterval);
                    }
                }
            }
            return s.charAt(s.length()-1)=='0'&&set.floor(new int[]{s.length()-1,s.length()-1})[1]>=s.length()-1;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("011010",
                2,
                3);
    }
}

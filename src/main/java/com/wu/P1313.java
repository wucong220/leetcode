package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2020/1/21 16:28
 */
public class P1313 {
    class Solution {
        public int[] decompressRLElist(int[] nums) {
            int save = 0;
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(i%2==0){
                    save = nums[i];
                }
                else{
                    for(int j=0;j<save;j++){
                        list.add(j);
                    }
                }
            }
            int[] ret = new int[list.size()];
            for(int i=0;i<ret.length;i++){
                ret[i]= list.get(i);
            }
            return ret;
        }
    }
}

package com.wu;

import java.util.LinkedList;

/**
 * @author wuc006
 * @date 2021/4/17 17:28
 */
public class CN1823 {
    class Solution {
        public int findTheWinner(int n, int k) {
            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0;i<n;i++){
                list.add(i+1);
            }
            int index = k-1;
            while(list.size()>1){
                list.remove(index);
                index = (index+k-1)%list.size();
            }
            return list.get(0);
        }
    }
}

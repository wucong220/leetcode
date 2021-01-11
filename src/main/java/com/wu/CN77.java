package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/9/10 11:16
 */
public class CN77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            return combine(n,k,0);
        }

        public List<List<Integer>> combine(int n, int k, int target) {
            List<List<Integer>> ret = new ArrayList<>();

            if(k==0){
                if(target<=n) {
                    ret.add(new ArrayList<>());
                }
                return ret;
            }
            if(target>n){
                return ret;
            }

            ret.addAll(combine(n,k,target+1));
            for (List<Integer> integers : combine(n, k - 1, target + 1)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(target);
                temp.addAll(integers);
                ret.add(temp);
            }
            return ret;
        }
    }
}

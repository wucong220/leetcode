package com.wu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2021/3/30 15:15
 */
public class CN421 {
    class Solution {
        public int findMaximumXOR(int[] nums) {
            Map<Integer,Map> root = new HashMap<>();
            for (int num : nums) {
                Map<Integer, Map> curr = root;
                for (int j = 31; j >= 0; j--) {
                    if (((num >>> j) & 1) == 1) {
                        curr.putIfAbsent(1, new HashMap<>());
                        curr = curr.get(1);
                    } else {
                        curr.putIfAbsent(0, new HashMap<>());
                        curr = curr.get(0);
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                Map<Integer, Map> curr = root;
                int xor =0;
                for (int j = 31; j >= 0; j--) {
                    if (((num >>> j) & 1) == 1) {
                        if(curr.get(0)!=null){
                            xor+= (1<<j);
                            curr = curr.get(0);
                        }
                        else{
                            curr = curr.get(1);
                        }
                    } else {
                        if(curr.get(1)!=null){
                            xor+= (1<<j);
                            curr = curr.get(1);
                        }
                        else{
                            curr = curr.get(0);
                        }
                    }
                }
                max = Math.max(xor,max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray("[3, 10, 5, 25, 2, 8]"));
    }
}

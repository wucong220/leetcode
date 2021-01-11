package com.wu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/1/5 9:29
 */
public class CN830 {
    class Solution {
        public List<List<Integer>> largeGroupPositions(String s) {
            s = s + '$';
            List<List<Integer>> list = new ArrayList<>();
            char[] chars = s.toCharArray();
            int start = -1;
            int end = 0;
            for (int i = 0; i < chars.length; i++) {
                if (start == -1) {
                    start = i;
                    end = i + 1;
                } else {
                    if (chars[i] == chars[i - 1]) {
                        end = i + 1;
                    } else {
                        if(end-start>=3){
                            list.add(Arrays.asList(start,end-1));
                        }
                        start = i;
                        end = i + 1;
                    }
                }
            }


            return list;
        }
    }
}

package com.wu;

/**
 * @author wuc006
 * @date 2021/3/8 17:03
 */
public class CN1784 {
    class Solution {
        public boolean checkOnesSegment(String s) {
            String[] split = s.split("0");
            return split.length==1;
        }
    }
}

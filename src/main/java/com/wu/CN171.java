package com.wu;
/**
 * @author wuc006
 * @date 2021/7/30 9:13
 */
public class CN171 {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int ret = 0;
            for (char c : columnTitle.toCharArray()) {
                ret = ret*26+(c-'A'+1);
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(RunUtil.run("ZY"));
    }
}

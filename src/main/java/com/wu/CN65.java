package com.wu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wuc006
 * @date 2021/6/17 9:16
 */
public class CN65 {
    class Solution {
        public boolean isNumber(String s) {
            Pattern compile = Pattern.compile("[+-]?(\\d+|\\d+\\.|\\d+\\.\\d+|\\.\\d+)([eE][+-]?\\d+)?");
            Matcher matcher = compile.matcher(s);
            return matcher.matches();
        }
    }

    public static void main(String[] args) {
        String[] valid = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        for (String s : valid) {
            RunUtil.run(s);
        }
        String[] invalid = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        for (String s : invalid) {
            RunUtil.run(s);
        }

    }
}

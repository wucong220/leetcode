package com.wu;

/**
 * @author wuc006
 * @date 2020/4/21 16:40
 */

import java.math.BigInteger;
import java.util.*;

public class P1416 {
    class Solution {
        public int numberOfArrays(String s, int k) {
            int[] d = new int[s.length() + 1];
            int kLength = String.valueOf(k).length();
            d[s.length()] = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '0') continue;
                long singleNum = 0;
                for (int j = 1; i + j < s.length() + 1; j++) {
                    singleNum = singleNum * 10 + (s.charAt(i + j - 1) - '0');
                    System.out.println(singleNum);
                    if (j<=kLength&&singleNum <= k) {
                        d[i] += d[i + j];
                        d[i] = d[i] % 1000_000_007;
                    } else {
                        break;
                    }
                }
            }
            return d[0];
        }
    }

    public static void main(String[] args) {
        RunUtil.methodName = "numberOfArrays";
        RunUtil.params = new Class[]{String.class, int.class};
        RunUtil.run("600342244431311113256628376226052681059918526204"
                , 703);
    }
}

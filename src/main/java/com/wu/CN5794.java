package com.wu;

import java.util.stream.IntStream;

public class CN5794 {
    class Solution {
        public boolean sumGame(String num) {
            int left = 0;
            int right = 0;
            int lqm = 0;
            int rqm = 0;
            for (int i = 0; i < num.length(); i++) {
                if (i < num.length() / 2) {
                    if (num.charAt(i) == '?') lqm++;
                    else left += num.charAt(i) - '0';
                } else {
                    if (num.charAt(i) == '?') rqm++;
                    else right += num.charAt(i) - '0';
                }
            }
            int gap = right - left;
            int qm = rqm - lqm;
            if (qm % 2 == 1) return true;
            else if (gap == 0 && qm == 0) return false;
            else if (gap * qm >= 0) return true;
            else {
                if (gap < 0) gap = -gap;
                return gap!=qm*9/2;
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run("?0?3105????1834??7382?997?3?????7?63116?566?701?065?13?3??38?7?488?????9");
    }
}

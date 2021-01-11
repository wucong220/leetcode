package com.wu;

/**
 * @author wuc006
 * @date 2020/12/18 15:54
 */
public class CN860 {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int count5=0;
            int count10=0;
            for (int bill : bills) {
                if (bill == 5) count5++;
                else if (bill == 10) {
                    if (count5 == 0) return false;
                    count10++;
                    count5--;
                } else if (bill == 20) {
                    if (count10 != 0) {
                        if (count5 == 0) return false;
                        count10--;
                        count5--;
                    } else if (count5 < 3) {
                        return false;
                    } else {
                        count5 -= 3;
                    }
                }
            }
            return true;
        }
    }
}

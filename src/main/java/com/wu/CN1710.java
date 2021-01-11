package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/1/5 14:04
 */
public class CN1710 {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
            int ret = 0;
            for (int[] boxType:boxTypes) {
               ret +=Math.min(boxType[0],truckSize)*boxType[1];
               truckSize-=Math.min(boxType[0],truckSize);
               if(truckSize==0)break;
            }
            return ret;
        }
    }
}

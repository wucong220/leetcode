package com.wu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2021/3/3 9:08
 */
public class CN338 {
    class Solution {
        public int[] countBits(int num) {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(1,0);
            map.put(2,1);
            map.put(4,2);
            map.put(8,3);
            map.put(16,4);
            map.put(32,5);
            map.put(64,6);
            map.put(128,7);
            map.put(256,8);
            map.put(512,9);
            map.put(1024,10);
            map.put(2048,11);
            map.put(4096,12);
            map.put(8192,13);
            map.put(16384,14);
            map.put(32768,15);
            map.put(65536,16);
            map.put(131072,17);
            map.put(262144,18);
            map.put(524288,19);
            map.put(1048576,20);
            map.put(2097152,21);
            map.put(4194304,22);
            map.put(8388608,23);
            map.put(16777216,24);
            map.put(33554432,25);
            map.put(67108864,26);
            map.put(134217728,27);
            map.put(268435456,28);
            map.put(536870912,29);
            map.put(1073741824,30);
            map.put(2147483647,31);
            int[] ret = new int[num+1];
            for(int i=0;i<num;i++){
                //lowest 0 bit
                int a = i^(i+1);
                a = a & i;
                a = a+1;
                int lowest0bitPos = map.get(a);
                ret[i+1] = ret[i] -lowest0bitPos+1;
            }
//            System.out.println(Arrays.toString(ret));
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(5);
    }
}

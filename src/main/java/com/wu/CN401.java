package com.wu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuc006
 * @date 2021/6/22 10:02
 */
public class CN401 {
    class Solution {
        int MARK = 0b111111;
        public List<String> readBinaryWatch(int turnedOn) {
            Set<Integer> ints = readBinaryWatch1(turnedOn);
            List<String> ret = new ArrayList<>();
            for (Integer n : ints) {
                int minute = n&MARK;
                int hour = n>>6;
                if(minute<=60&&hour<=11)
                ret.add(String.format("%02d:%02d",hour,minute));
            }
            return ret;
        }

        private Set<Integer> readBinaryWatch1(int turnedOn) {
            Set<Integer> ret = new HashSet<>();
            if(turnedOn==0){
                ret.add(0);
                return ret;
            }
            else if(turnedOn==1){
                for(int i=0;i<10;i++){
                    int curr = 1<<i;
                    ret.add(curr);
                }
                return  ret;
            }
            else {
                Set<Integer> ints = readBinaryWatch1(turnedOn - 1);
                for (Integer n : ints) {
                    for (int i = 0; i < 10; i++) {
                        if (((1 << i) & n) == 0) {
                            ret.add((1<<i)|n);
                        }
                    }
                }
                return ret;
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.methodName="readBinaryWatch";
        RunUtil.run(4);
    }
}

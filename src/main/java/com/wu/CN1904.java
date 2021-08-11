package com.wu;
/**
 * @author wuc006
 * @date 2021/6/21 14:46
 */
public class CN1904 {
    class Solution {
        public int numberOfRounds(String startTime, String finishTime) {
            if(finishTime.compareTo(startTime)<0)return numberOfRounds(startTime,"24:00")+numberOfRounds("00:00",finishTime);
            String[] split = startTime.split(":");
            int ms = Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
            ms = (ms/15)+(ms%15>0?1:0);
            split = finishTime.split(":");
            int mf = Integer.parseInt(split[0])*60 + Integer.parseInt(split[1]);
            mf = mf/15;
            return mf-ms;
        }
    }

    public static void main(String[] args) {
        String startTime = "20:00", finishTime = "06:00";
        RunUtil.run(startTime,finishTime);
    }
}

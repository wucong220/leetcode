package com.wu;

/**
 * @author wuc006
 * @date 2021/7/31 17:04
 */
public class CN1736 {
    class Solution {
        public String maximumTime(String time) {
            final String[] split = time.split(":");
            String ret="";
            for(int i=23;i>=0;i--){
                final String format = String.format("%02d", i);
                if((format.charAt(0)==split[0].charAt(0)||split[0].charAt(0)=='?')
                        &&(format.charAt(1)==split[0].charAt(1)||split[0].charAt(1)=='?')){
                       ret+=format;
                       break;
                }
            }
            ret+=":";
            for(int i=59;i>=0;i--){
                final String format = String.format("%02d", i);
                if((format.charAt(0)==split[1].charAt(0)||split[1].charAt(0)=='?')
                        &&(format.charAt(1)==split[1].charAt(1)||split[1].charAt(1)=='?')){
                    ret+=format;
                    break;
                }
            }

            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("0?:?4");
    }
}

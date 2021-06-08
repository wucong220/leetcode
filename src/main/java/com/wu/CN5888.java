package com.wu;

import java.util.Locale;

/**
 * @author wuc006
 * @date 2021/6/7 11:49
 */
public class CN5888 {
    class Solution {
        public int minFlips(String s) {
            if(s.length()%2==0){
                char[] ch = s.toCharArray();
                int ctr = 0;
                int min;
                for(int i=0;i<s.length();i++){
                    if(i%2==0){
                        if(ch[i]=='1') ctr++;
                    }
                    else{
                        if(ch[i]=='0') ctr++;
                    }
                }
                min = ctr;
                ctr = 0;
                ch = s.toCharArray();
                for(int i=0;i<s.length();i++){
                    if(i%2==0){
                        if(ch[i]=='0') ctr++;
                    }
                    else{
                        if(ch[i]=='1') ctr++;
                    }
                }
                min = Math.min(ctr,min);
                return min;
            }
            else{
                //0结尾无结节
                int[] d1 = new int[s.length()];
                //0结尾有结节
                int[] d2 = new int[s.length()];
                //1结尾无结节
                int[] d3 = new int[s.length()];
                //1结尾有结节
                int[] d4 = new int[s.length()];
                char[] ch = s.toCharArray();
                for(int i=0;i<ch.length;i++){
                    if(i==0){
                        if(ch[i]=='0') d3[i] = 1;
                        else d1[i] = 1;
                        d2[i]=Integer.MAX_VALUE;
                        d4[i]=Integer.MAX_VALUE;
                    }
                    else{
                        int dd1 = d1[i-1];
                        int dd2 = d2[i-1];
                        int dd3 = d3[i-1];
                        int dd4 = d4[i-1];
                        if(ch[i]=='0'){
                            d1[i] = dd3;
                            d2[i] = Math.min(dd1,dd4);
                            d3[i] = dd1+1;
                            d4[i] = Math.min(dd2,dd3)+1;
                        }
                        else{
                            d1[i] = dd3+1;
                            d2[i] = Math.min(dd1,dd4)+1;
                            d3[i] = dd1;
                            d4[i] = Math.min(dd2,dd3);
                        }
                    }
                }
                int ret = Integer.MAX_VALUE;
                ret = Math.min(ret,d1[s.length()-1]);
                ret = Math.min(ret,d2[s.length()-1]);
                ret = Math.min(ret,d3[s.length()-1]);
                ret = Math.min(ret,d4[s.length()-1]);
                //尼玛死了，哈哈哈哈哈哈哈夜夜夜夜，尼玛死掉了，如果说有人的吗死了，那肯定是你的亲妈
                //啦啦啦
                //李莉莉
                //芜湖。起飞
                //起飞。芜湖
                //人生得意需尽欢。莫使金樽空对月
                //嚯嚯嚯
                return ret;
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run("1110");
    }
}

package com.wu;

/**
 * @author wuc006
 * @date 2021/5/31 9:26
 */
public class CN5773 {
    class Solution {
        public String maxValue(String n, int x) {
            if(n.charAt(0)=='-'){
                n = n.substring(1);
                for(int i=0;i<n.length();i++){
                    if(n.charAt(i)-'0'>x){
                        return "-"+n.substring(0,i)+x+n.substring(i);
                    }
                }
                return "-"+n + x;
            }
            else{
                for(int i=0;i<n.length();i++){
                    if(n.charAt(i)-'0'<x){
                        return n.substring(0,i)+x+n.substring(i);
                    }
                }
                return n + x;
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run("123",9);
        RunUtil.run("-123",9);
    }
}

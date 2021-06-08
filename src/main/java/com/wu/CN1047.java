package com.wu;


/**
 * @author wuc006
 * @date 2021/3/9 9:13
 */
public class CN1047 {
    class Solution {
        public String removeDuplicates(String S) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<S.length();i++){
                if(sb.length()>0) {
                    char lastChar = sb.charAt(sb.length() - 1);
                    if(S.charAt(i)!=lastChar){
                        sb.append(S.charAt(i));
                    }
                    else{
                        sb.deleteCharAt(sb.length()-1);
                    }
                }
                else{
                    sb.append(S.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}

package com.wu;

/**
 * @author wuc006
 * @date 2020/12/18 11:11
 */
public class CN738 {
    class Solution {
        public int monotoneIncreasingDigits(int N) {
            String str = String.valueOf(N);
            char[] chars = str.toCharArray();
            for (int i = chars.length-1; i >0; i--) {
                if(chars[i]<chars[i-1]){
                    chars[i-1] = (char) (chars[i-1]-1);
                    for(int j=i;j<chars.length&&chars[j]!='9';j++){
                        chars[j]='9';
                    }
                }
            }
            return Integer.parseInt(String.valueOf(chars));
        }
    }

    public static void main(String[] args) {
        RunUtil.run(322);
    }
}

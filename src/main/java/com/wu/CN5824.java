package com.wu;

public class CN5824 {
    class Solution {
        public String maximumNumber(String num, int[] change) {
            char[] charArray = num.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                int n = c - '0';
                if(change[n]>n){
                    for(int j=i;j<charArray.length;j++){
                        char cc = charArray[i];
                        int nn = cc - '0';
                        if(change[nn]>=nn){
                            charArray[j] = (char)(change[nn]+'0');
                        }
                        else{
                            break;
                        }
                    }
                    return String.valueOf(charArray);
                }
            }
            return String.valueOf(charArray);
        }
    }

    public static void main(String[] args) {

        RunUtil.run("021",RunUtil.toArray("[9,4,3,5,7,2,1,9,0,6]"));
    }
}

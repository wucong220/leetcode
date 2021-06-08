package com.wu;

public class CN5760 {
    class Solution {
        public int minSwaps(String s) {
            char[] ch = s.toCharArray();
            int[] count = new int[2];
            for(int i=0;i<ch.length;i++) {
                count[ch[i] - '0']++;
            }
            if(Math.abs(count[0]-count[1])>1)return -1;

            int ctr = 0;
            if(count[0]>count[1]){
                ctr = getCtr1(ch.clone());
            }
            else if(count[0]<count[1]) {
                ctr = getCtr2(ch.clone());
            }
            else{
                ctr = Math.min(getCtr1(ch.clone()),getCtr2(ch.clone()));
            }
            return ctr;
        }

        int getCtr1(char[] ch){
            //偶数是0，奇数是1
            int ctr = 0;
            for(int i=0;i<ch.length;i++){
                if(i%2==0&&ch[i]=='1'){
                    for(int j=0;j<ch.length;j++){
                        if(j%2==1&&ch[j]=='0'){
                            char temp = ch[i];
                            ch[i] = ch[j];
                            ch[j] = temp;
                            break;
                        }
                    }
                    ctr++;
                }
            }
            return ctr;
        }

        int getCtr2(char[] ch){
            //偶数是1，奇数是0
            int ctr = 0;
            for(int i=0;i<ch.length;i++){
                if(i%2==0&&ch[i]=='0'){
                    for(int j=0;j<ch.length;j++){
                        if(j%2==1&&ch[j]=='1'){
                            char temp = ch[i];
                            ch[i] = ch[j];
                            ch[j] = temp;
                            break;
                        }
                    }
                    ctr++;
                }
            }
            return ctr;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("111000");
    }
}

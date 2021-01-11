package com.wu;

/**
 * @author wuc006
 * @date 2020/1/19 9:28
 */
public class P1318 {
    class Solution {
        public int minFlips(int a, int b, int c) {
            if((a|b)==c)return 0;
            int count=0;
            for(int i=0;i<32;i++){
                int a_bit = (a>>i)&1;
                int b_bit = (b>>i)&1;
                int c_bit = (c>>i)&1;
                if(c_bit==1){
                    if((a_bit+b_bit)==0){
                        count+=1;
                    }
                }
                else{
                    count+=a_bit+b_bit;
                }
            }

            return count;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(4,2,7);
    }
}

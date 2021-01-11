package com.wu;

/**
 * @author wuc006
 * @date 2020/5/14 10:39
 */
public class P1432 {
    class Solution{
        public int maxDiff(int num) {
            int n = 1;
            int temp = num;
            while(temp>0){
                temp=temp/10;
                n=n*10;
            }
            n=n/10;
            int highestDigit = num/n;
            int numWithoutHD = num%n;

            int max = 0;
            int min = 0;
            temp = num;
            int pos = 1;
            while(temp>0){
                int digit = temp%10;
                temp = temp/10;
                max = (digit==highestDigit?9:digit)*pos+max;
                min = (digit==highestDigit?1:digit)*pos+min;
                pos=pos*10;
            }
            if(highestDigit==1){
                temp = numWithoutHD;
                int tempN = n/10;
                while(tempN>0){
                    int digit = temp/tempN;
                    temp = temp%tempN;
                    if(digit!=0&&digit!=1){
                        min = replace(num,digit,0);
                        break;
                    }
                    tempN = tempN/10;
                }
            }
            else if(highestDigit==9){
                temp = numWithoutHD;
                int tempN = n/10;
                while(tempN>0){
                    int digit = temp/tempN;
                    temp = temp%tempN;
                    if(digit!=9){
                        max = replace(num,digit,9);
                        break;
                    }
                    tempN = tempN/10;
                }
            }
            return max-min;
        }

        public int replace(int input,int src,int trg) {
            int temp = input;
            int ret = 0;
            int n = 1;
            while (temp > 0) {
                int digit = temp % 10;
                temp = temp / 10;
                if (digit == src) digit = trg;
                ret += digit * n;
                n = n * 10;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.methodName="maxDiff";
        RunUtil.params=new Class[]{int.class};
        RunUtil.run(1101057);
    }
}

package com.wu;

import javax.management.relation.RoleUnresolved;
import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class CN1850 {
    class Solution {
        int ret = 0;
        public int getMinSwaps(String num, int k) {
            char[] chars = num.toCharArray();

            for(int i=0;i<k;i++) {
                findNext(chars);
            }
            char[] origin = num.toCharArray();
            for(int i=origin.length-1;i>=1;i--){
                int j = 0;
                for(j=i;j>=0;j--){
                    if(origin[i]==chars[j]){
                        break;
                    }
                }
                for(int l = j;l<i;l++){
                    swap(chars,l,l+1);
                    ret++;
                }
            }

            return ret;
        }

        private void findNext(char[] chars) {
            for(int i=chars.length-1;i>0;i--){
                if(chars[i]>chars[i-1]){
                    char temp = chars[i-1];
                    char min =Character.MAX_VALUE;
                    int index = -1;
                    for(int j=i;j<chars.length;j++){
                        if(chars[j]>temp&&chars[j]<min){
                            min = chars[i];
                            index = j;
                        }
                    }
                    swap(chars,index,i-1);
                    Arrays.sort(chars,i,chars.length);
                    break;
                }
            }
        }

        private void swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("99499",1);
    }
}

package com.wu;

import sun.text.normalizer.UCharacter;

import java.util.*;

/**
 * @author wuc006
 * @date 2020/4/23 15:40
 */
public class P1405 {
    class Solution {
        int max = 0;
        String maxStr = null;
        public String longestDiverseString(int a, int b, int c) {
            LinkedList<Character> sb = new LinkedList<>();
            dfs(sb,new int[]{a,b,c});
            return maxStr;
        }

        public void dfs (LinkedList<Character> sb,int[] abc){
            if(sb.size()>max){
                max = sb.size();
                char[] sbc = new char[sb.size()];
                for (int i = 0; i < sb.size(); i++) {
                    Character character =  sb.get(i);
                    sbc[i] = character;
                }
                maxStr = String.valueOf(sbc);
            }
            if(sb.size()>=2){
                char lastChar = sb.get(sb.size() - 1);
                char secondLastChar = sb.get(sb.size()-2);
                if(lastChar==secondLastChar){
                    for(int i=0;i<3;i++){
                        char ch = (char) (i + 'a');
                        if(ch!=lastChar&&abc[i]>0) {
                            sb.add(ch);
                            abc[i]--;
                            dfs(sb,abc);
                            abc[i]++;
                            sb.removeLast();
                        }
                    }
                }
                else{
                    for (int i = 0; i < 3; i++) {
                        char ch = (char) (i + 'a');
                        if (abc[i] > 0) {
                            sb.add(ch);
                            abc[i]--;
                            dfs(sb, abc);
                            abc[i]++;
                            sb.removeLast();
                        }
                    }
                }
            }else {
                for (int i = 0; i < 3; i++) {
                    char ch = (char) (i + 'a');
                    if (abc[i] > 0) {
                        sb.add(ch);
                        abc[i]--;
                        dfs(sb, abc);
                        abc[i]++;
                        sb.removeLast();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.params= new Class[]{int.class,int.class,int.class};
        RunUtil.methodName = "longestDiverseString";
        RunUtil.run(20,20,20);
    }
}

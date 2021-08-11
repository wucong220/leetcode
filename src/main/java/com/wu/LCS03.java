package com.wu;

/**
 * @author wuc006
 * @date 2021/6/21 10:56
 */
public class LCS03 {
    class Solution {
        public int largestArea(String[] grid) {
            char[][] ch = new char[grid.length][grid[0].length()];
            for (int i = 0; i < grid.length; i++) {
                ch[i] = grid[i].toCharArray();
            }
            for(int i=0;i<ch.length;i++){
                for(int j=0;j<ch[0].length;j++){
                    if(i==0||i==ch.length-1||j==0||j==ch[0].length-1
                           ||ch[i-1][j]=='0'||ch[i+1][j]=='0'||ch[i][j-1]=='0'||ch[i][j+1]=='0'){
                        defuse(ch,i,j,ch[i][j]);
                    }
                }
            }
            int max = 0;
            for(int i=0;i<ch.length;i++){
                for(int j=0;j<ch[0].length;j++){
                    if(ch[i][j]!='0'&&ch[i][j]!='-'){
                        max = Math.max(defuse2(ch,i,j,ch[i][j]),max);
                    }
                }
            }
            return max;
        }

        private int defuse2(char[][] ch, int i, int j, char group) {
            if(ch[i][j]!=group)return 0;
            ch[i][j]='0';
            int ret = 1;
            ret +=defuse2(ch,i-1,j,group);
            ret +=defuse2(ch,i+1,j,group);
            ret +=defuse2(ch,i,j-1,group);
            ret +=defuse2(ch,i,j+1,group);
            return ret;
        }

        private void defuse(char[][] ch, int i, int j,char group) {
            if(i<0||i>ch.length-1||j<0||j>ch[0].length-1||ch[i][j]!=group||ch[i][j]=='-'||ch[i][j]=='0')return;
            ch[i][j]='-';
            defuse(ch,i-1,j,group);
            defuse(ch,i+1,j,group);
            defuse(ch,i,j-1,group);
            defuse(ch,i,j+1,group);
        }
    }

    public static void main(String[] args) {
        RunUtil.run((Object) new String[]{"11111100000","21243101111","21224101221","11111101111"});
    }
}

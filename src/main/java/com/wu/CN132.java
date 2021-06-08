package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/3/8 9:09
 */
public class CN132 {
    class Solution {
        boolean d[][];

        public int minCut(String s) {
            test(s);
            int[][] d1 = new int[s.length()][s.length()];
            for(int w=1;w<=d.length;w++){
                for(int i=0;i+w-1<d.length;i++){
                    int j = i+w-1;
                    if(w==1)d1[i][j]=1;
                    else if(w==2)d1[i][j]=(d[i][j]?1:2);
                    else{
                        d1[i][j] = Integer.MAX_VALUE;
                        if(d[i][j]){
                            d1[i][j]=1;
                        }
                        else{
                            for(int k=i;k<j;k++){
                                d1[i][j] = Math.min(d1[i][j],d1[i][k]+d1[k+1][j]);
                            }
                        }
                    }
                }
            }
            return d1[0][s.length()-1]-1;
        }

        void test(String s){
            d = new boolean[s.length()][s.length()];
            for(int w=1;w<=d.length;w++){
                for(int i=0;i+w-1<d.length;i++){
                    int j = i+w-1;
                    if(w==1)d[i][j]=true;
                    else if(w==2)d[i][j]=(s.charAt(i)==s.charAt(j));
                    else{
                        if(s.charAt(i)==s.charAt(j))d[i][j]=d[i+1][j-1];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RunUtil.run("aab");
    }
}

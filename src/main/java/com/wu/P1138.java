package com.wu;

import java.util.Collections;

/**
 * Alphabet Board Path
 * https://leetcode.com/contest/weekly-contest-147/problems/alphabet-board-path/
 * @author wuc006
 * @date 2019/7/30 16:54
 */
public class P1138 {
    class Solution {
        public String alphabetBoardPath(String target) {
            StringBuffer sb = new StringBuffer();
            char[] target_ = target.toCharArray();
            char[][] board = {
                    {'a','b','c','d','e'},
                    {'f','g','h','i','j'},
                    {'k','l','m','n','o'},
                    {'p','q','r','s','t'},
                    {'u','v','w','x','y'},
                    {'z'}
            };
            int pos_x=0,pos_y=0;
            for(int i=0;i<target.length();i++){
                int target_x = (target_[i]-'a')%5;
                int target_y = (target_[i]-'a')/5;
                int gap_x = target_x-pos_x;
                int gap_y = target_y-pos_y;
                if(target_y==5){
                    sb.append(String.join("", Collections.nCopies(Math.abs(gap_x),(gap_x>0?"R":"L"))));
                    sb.append(String.join("", Collections.nCopies(Math.abs(gap_y),(gap_y>0?"D":"U"))));
                }
                else{
                    sb.append(String.join("", Collections.nCopies(Math.abs(gap_y),(gap_y>0?"D":"U"))));
                    sb.append(String.join("", Collections.nCopies(Math.abs(gap_x),(gap_x>0?"R":"L"))));
                }
                sb.append('!');
                pos_x=target_x;
                pos_y=target_y;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new P1138().new Solution().alphabetBoardPath("code"));
        System.out.println('B'*10);
        System.out.println(String.join("1",Collections.nCopies(2,"c")));
    }
}

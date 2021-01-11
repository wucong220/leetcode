package com.wu;

/**
 * @author wuc006
 * @date 2020/11/9 16:37
 */

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class CN10 {
    /**
     * 有限自动机
     *  '.'-all->
     * 'w'-w->
     * 'a*'-""|a+->
     */
    class Solution {
        public boolean isMatch(String s, String p) {
            List<String> ps = new ArrayList<>();
            for(int i=0;i<p.length();i++){
                char c = p.charAt(i);
                if(c!='*'){
                    if(i<p.length()-1&&p.charAt(i+1)=='*'){
                        ps.add(c+"*");
                    }
                    else{
                        ps.add(c+"");
                    }
                }
            }
            boolean[][] d = new boolean[s.length()+1][ps.size()+1];
            for(int i=s.length();i>=0;i--){
                for(int j=ps.size();j>=0;j--){
                    if(i==s.length()&&j==ps.size()){
                        d[i][j]=true;
                    }
                    else if(j==ps.size()){
                        d[i][j]=false;
                    }
                    else if(i==s.length()){
                        if(ps.get(j).length()==2) {
                            d[i][j] = d[i][j + 1];
                        }
                        else {
                            d[i][j]=false;
                        }
                    }
                    else{
                        if(ps.get(j).length()==1){
                            if(ps.get(j).charAt(0)==s.charAt(i)||ps.get(j).charAt(0)=='.'){
                                d[i][j]=d[i+1][j+1];
                            }
                            else{
                                d[i][j]=false;
                            }
                        }
                        else{
                            if(ps.get(j).charAt(0)==s.charAt(i)||ps.get(j).charAt(0)=='.'){
                                d[i][j]=d[i+1][j+1]||d[i][j+1]||d[i+1][j];
                            }
                            else{
                                d[i][j]=d[i][j+1];
                            }
                        }
                    }
                }
            }
            return d[0][0];
        }
    }

    public static void main(String[] args) {
        RunUtil.run("ab",".*");
    }
}

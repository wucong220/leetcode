package com.wu;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wuc006
 * @date 2021/3/10 9:08
 */
public class CN224 {
    class Solution {
        public int calculate(String s) {
            s = s.replaceAll(" ", "");
            int ret= 0 ;
            Deque<Character> operators = new LinkedList<>();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c=='+'||c=='-')operators.push(c);
                else if(c=='('){
                    int top = 1;
                    for(int j=i+1;j<s.length();j++){
                        if(s.charAt(j)==')'){
                            top--;
                            if(top==0) {
                                int calculate = calculate(s.substring(i + 1, j));
                                int sign = 1;
                                while(!operators.isEmpty()){
                                    if(operators.pop()=='-')sign = -sign;
                                }
                                ret += calculate*sign;
                                i = j;
                                break;
                            }
                        }
                        else if(s.charAt(j)=='(')top++;
                    }
                }
                else{
                    int curr = c-'0';
                    for(int j=i+1;j<s.length();j++,i++){
                        if(s.charAt(j)>='0'&&s.charAt(j)<='9'){
                            curr=curr*10+s.charAt(j)-'0';
                        }
                        else{
                            break;
                        }
                    }
                    int sign = 1;
                    while(!operators.isEmpty()){
                        if(operators.pop()=='-')sign = -sign;
                    }
                    ret += curr*sign;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("-2+ 1");
    }
}

package com.wu;

import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * @author wuc006
 * @date 2020/9/2 17:09
 */
public class CN20 {
    class Solution {
        public boolean isValid(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            for(char c:s.toCharArray()){
                switch(c){
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);break;
                    case ')':if(!stack.isEmpty()&&stack.peek()=='(')stack.pop();else stack.push(c);break;
                    case ']':if(!stack.isEmpty()&&stack.peek()=='[')stack.pop();else stack.push(c);break;
                    case '}':if(!stack.isEmpty()&&stack.peek()=='{')stack.pop();else stack.push(c);break;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        RunUtil.run("]" );
    }
}

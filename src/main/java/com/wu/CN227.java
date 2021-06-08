package com.wu;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wuc006
 * @date 2021/3/11 9:07
 */
public class CN227 {
    class Solution {
        public int calculate(String s) {
            Deque<Integer> stack = new LinkedList<>();
            Deque<Character> cStack = new LinkedList<>();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c==' ')continue;
                else if(c>='0'&&c<='9'){
                    int value = 0;
                    while(i<s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                        value= value*10+s.charAt(i)-'0';
                        i++;
                    }
                    i--;
                    char peek = cStack.isEmpty()?'n':cStack.peek();
                    if(peek=='*'){
                        cStack.pop();
                        cStack.pop();
                        Integer first = stack.pop();
                        cStack.push('i');
                        stack.push(first*value);
                    }
                    else if(peek =='/'){
                        cStack.pop();
                        cStack.pop();
                        Integer first = stack.pop();
                        cStack.push('i');
                        stack.push(first/value);
                    }
                    else{
                        stack.push(value);
                        cStack.push('i');
                    }
                }
                else{
                    cStack.push(c);
                }
            }

            while(stack.size()!=0){
                int value = stack.removeLast();
                cStack.removeLast();
                if(!cStack.isEmpty()){
                    char operator = cStack.removeLast();
                    cStack.removeLast();
                    int last = stack.removeLast();
                    stack.addLast(getV(value,last,operator));
                    cStack.addLast('i');
                }
                else{
                    return value;
                }
            }
            return 0;
        }

        private Integer getV(int first, int value,char operator) {
            switch (operator){
                case '+':return first+value;
                case '-':return first-value;
                case '*':return first*value;
                case '/':return first/value;
            }
            throw new RuntimeException("error");
        }
    }

    public static void main(String[] args) {
        RunUtil.run("0-2147483647");
    }
}

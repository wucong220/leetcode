package com.wu;

import java.util.LinkedList;

public class CN150 {
    class Solution {
        LinkedList<Integer> stack = new LinkedList<>();
        public int evalRPN(String[] tokens) {
            for (String token : tokens) {
                switch (token){
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        Integer pop2 = stack.pop();
                        Integer pop1 = stack.pop();
                        stack.push(operation(pop1,pop2,token));
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }

        private int operation(Integer pop1, Integer pop2, String token) {
            int n1 = pop1;
            int n2 = pop2;
            switch (token){
                case "+": return n1+n2;
                case "-": return n1-n2;
                case "*": return n1*n2;
                case "/": return n1/n2;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        RunUtil.run((Object) new String[]{"2","1","+","3","*"});
    }
}

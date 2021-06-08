package com.wu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2021/3/12 17:27
 */
public class CN331 {
    class Solution {
        public boolean isValidSerialization(String preorder) {
            return isValidSerialization(Arrays.stream(preorder.split(",")).map(a->a.charAt(0)+"").collect(Collectors.joining("")),0,new LinkedList<>());
        }

        public boolean isValidSerialization(String preorder,int curr,LinkedList<Character> stack) {
            if(curr==preorder.length())return stack.isEmpty();
            if(preorder.charAt(curr)=='#'){
                int i=curr+1;
                for(;i<preorder.length();i++) {
                    char next = preorder.charAt(i);
                    if(next!='#'){
                        if(stack.isEmpty())return false;
                        else{
                            stack.pop();
                            stack.push( next);
                            return isValidSerialization(preorder,i+1,stack);
                        }
                    }
                    else{
                        if(stack.isEmpty())return false;
                        else stack.pop();
                    }
                }
            }
            else{
                stack.push(preorder.charAt(curr));
                return isValidSerialization(preorder,curr+1,stack);
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        RunUtil.run("9,#,92,#,#");
    }
}

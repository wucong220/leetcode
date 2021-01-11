package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/12/18 16:18
 */
public class CN842 {
    class Solution {
        public List<Integer> splitIntoFibonacci(String S) {
            for(int i=1;i<S.length();i++){
                String substring = S.substring(0, i);
                if(Long.parseLong(substring)>Integer.MAX_VALUE)break;
                int n1 = Integer.parseInt(substring);
                List<Integer> integers = splitIntoFibonacci(S.substring(i), n1);
                if(integers!=null){
                    List<Integer> list= new ArrayList<>();
                    list.add(n1);
                    list.addAll(integers);
                    return list;
                }
                if(substring.equals("0"))break;
            }
            return new ArrayList<>();
        }

        private List<Integer> splitIntoFibonacci(String S, int n1) {
            for(int i=1;i<S.length();i++){
                String subString = S.substring(0, i);
                if(Long.parseLong(subString)>Integer.MAX_VALUE)break;
                int n2 = Integer.parseInt(subString);
                List<Integer> integers = splitIntoFibonacci(S.substring(i),n1,n2);
                if(integers!=null){
                    List<Integer> list= new ArrayList<>();
                    list.add(n2);
                    list.addAll(integers);
                    return list;
                }
                if(subString.equals("0"))break;
            }
            return null;
        }

        private List<Integer> splitIntoFibonacci(String substring, int n1, int n2) {

            long temp = (long)n1 + (long)n2;
            if(temp>Integer.MAX_VALUE)return null;
            int n3 = (int) temp;
            String n3str = String.valueOf(n3);
            if(substring.startsWith(n3str)){
                if(substring.length()==n3str.length()){
                    List<Integer> list = new ArrayList<>();
                    list.add(n3);
                    return list;
                }
                else if(substring.length()>n3str.length()) {
                    List<Integer> integers = splitIntoFibonacci(substring.substring(n3str.length()), n2, n3);
                    if(integers!=null){
                        List<Integer> list= new ArrayList<>();
                        list.add(n3);
                        list.addAll(integers);
                        return list;
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("214748364721474836422147483641");
    }
}

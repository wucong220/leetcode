package com.wu;

import java.util.ArrayList;
import java.util.List;

public class CN131 {
    class Solution {
        public List<List<String>> partition(String s) {
            return partition(s,0);
        }

        public List<List<String>> partition(String s,int start) {
            List<List<String>> ret = new ArrayList<>();
            if(start==s.length())ret.add(new ArrayList<>());
            for(int i=start;i<s.length();i++){
                if(isPa(s,start,i)){
                    List<List<String>> partition = partition(s, i + 1);
                    for (List<String> strings : partition) {
                        strings.add(0,s.substring(start,i+1));
                        ret.add(strings);
                    }
                }
            }
            return ret;
        }

        boolean isPa(String s, int i ,int j){
            for(;i<j;i++,j--){
                if(s.charAt(i)!=s.charAt(j))return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("aab");
    }
}

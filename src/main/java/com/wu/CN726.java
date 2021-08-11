package com.wu;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class CN726 {
    class Solution {
        public String countOfAtoms(String formula) {
            Map<String, Integer> map = countOfAtoms1(formula);
            StringBuilder sb = new StringBuilder();
            map.forEach((k,v)->sb.append(k).append(v>0?v:""));
            return sb.toString();
        }

        public Map<String,Integer> countOfAtoms1(String formula) {
            Map<String,Integer> ret = new TreeMap<>();
            for(int i=0;i<formula.length();){
                char c = formula.charAt(i);
                if(c >='A'&&c<='Z'){
                    String eName =""+ c;
                    int eCount=0;
                    int j=i+1;
                    for(;j<formula.length();j++){
                        char c1 = formula.charAt(j);
                        if(c1<='z'&&c1>='a'){
                            eName=eName+c1;
                        } else if (c1 <= '9' && c1 >= '0') {
                            eCount = eCount*10+(c1-'0');
                        }
                        else{
                            break;
                        }
                    }
                    ret.merge(eName,eCount==0?1:eCount,Integer::sum);
                    i=j;
                }
                else if(c=='('){
                    int j=i+1;
                    int top=1;
                    for(;j<formula.length();j++){
                        char c1 = formula.charAt(j);
                        if(c1=='(')top++;
                        else if(c1==')')top--;
                        if(top==0)break;
                    }
                    int bCount = 0;
                    int k=j+1;
                    for(;k<formula.length();k++){
                        char c1 = formula.charAt(k);
                        if (c1 <= '9' && c1 >= '0') {
                            bCount = bCount*10+(c1-'0');
                        }
                        else{
                            break;
                        }
                    }
                    Map<String, Integer> subMap = countOfAtoms1(formula.substring(i + 1, j));
                    if(bCount>0){
                        for(String e:subMap.keySet()){
                            subMap.merge(e,bCount,(a,b)->a*b);
                        }
                    }
                    for(String e:subMap.keySet()){
                        ret.merge(e,subMap.get(e),Integer::sum);
                    }
                    i=k;
                }
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        RunUtil.run("K4(ON(SO3)2)2");
    }
}

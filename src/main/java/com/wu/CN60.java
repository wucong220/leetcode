package com.wu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/9/10 11:44
 */
public class CN60 {
    class Solution {
        StringBuilder sb = new StringBuilder();
        List<Integer> tab = null;
        public String getPermutation(int n, int k) {
            if(tab==null){
                tab = new ArrayList<>();
                for(int i=0;i<n;i++){
                    tab.add(i+1);
                }
            }
            if(n==1){
                sb.append(tab.get(0));
                return sb.toString();
            }
            //(n-1)!
            int scale=1;
            for(int i=1;i<n;i++){
                scale *= i;
            }
            int group =  (k-1)/scale;
            sb.append(tab.get(group));
            tab.remove(tab.get(group));
            getPermutation(n-1,(k-1)%scale+1);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
//        RunUtil.methodName="getPermutation";
        Object run = RunUtil.run(3, 3);
        System.out.println(run);
    }
}

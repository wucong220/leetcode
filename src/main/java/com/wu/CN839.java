package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/2/2 15:14
 */
public class CN839 {
    class AndCheckSet {
        int[] f;

        public AndCheckSet(int size){
            f = new int[size];
            for(int i=0;i<size;i++){
                f[i]=i;
            }
        }

        int findParent(int a){
            while(f[a]!=a){
                a = f[a];
            }
            return a;
        }

        boolean isSameSet(int a,int b){
            return findParent(a)==findParent(b);
        }

        void pathCompression(int a,int n){
            while(f[a]!=n){
                int temp = f[a];
                f[a] = n;
                a = temp;
            }
        }

        void union(int a,int b){
            int aP = findParent(a);
            int bP = findParent(b);
            if (aP != bP) {
                pathCompression(a,bP);
                pathCompression(b,bP);
            }
        }

        int count(){
            for (int i=0;i<f.length;i++) {
                int p = findParent(i);
                pathCompression(i,p);
            }
            return (int) Arrays.stream(f).distinct().count();
        }
    }

    class Solution {
        public int numSimilarGroups(String[] strs) {
            AndCheckSet acs = new AndCheckSet(strs.length);
            for(int i=0;i<strs.length;i++){
                for(int j=0;j<strs.length;j++){
                    if(similar(strs[i],strs[j])){
                        acs.union(i,j);
                    }
                }
            }
            return acs.count();
        }

        public boolean similar(String a,String b){
            int count=0;
            for(int i=0;i<a.length();i++){
                if(a.charAt(i)!=b.charAt(i))count++;
            }
            return count<=2;
        }
    }

    public static void main(String[] args) {
        RunUtil.run((Object) new String[]{"tars","rats","arts","star"});
    }
}

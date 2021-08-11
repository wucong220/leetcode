package com.wu;

import java.util.*;

public class CN5816 {
    class Solution {
        int[][] queries;
        Map<Integer, List<Integer>> queriesMap = new HashMap<>();
        Map<Integer,List<Integer>> nextMap= new HashMap<>();
        int[] ret;
        TrieNode root;

        public int[] maxGeneticDifference(int[] parents, int[][] queries) {
            this.queries = queries;
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                queriesMap.putIfAbsent(query[0], new ArrayList<>());
                queriesMap.get(query[0]).add(i);
            }
            ret = new int[queries.length];

            for (int i = 0; i < parents.length; i++) {
                nextMap.putIfAbsent(parents[i],new ArrayList<>());
                nextMap.get(parents[i]).add(i);
            }
            root = new TrieNode();

            dfs(nextMap.get(-1).get(0));
            return ret;
        }

        private void dfs(int curr) {
            List<Integer> nexts = nextMap.get(curr);
            addTrieNode(curr);
            List<Integer> queriesIndex = queriesMap.get(curr);
            if(queriesIndex!=null) {
                for (Integer index : queriesIndex) {
                    int[] query = queries[index];
                    int val = query[1];
                    int ans = queryTrieNode(val);
                    ret[index] = ans;
                }
            }

            if(nexts!=null) {
                for (Integer next : nexts) {
                    dfs(next);
                }
            }
            removeTrieNode(curr);
        }

        private void addTrieNode(int curr) {
            TrieNode pre = root;
            for(int i=31;i>=0;i--){
                if(((curr>>i)&1)==0){
                    if(pre.next[0]==null)pre.next[0]=new TrieNode();
                    pre.next[0].val=0;
                    pre = pre.next[0];
                    pre.ctr++;
                }
                else{
                    if(pre.next[1]==null)pre.next[1]=new TrieNode();
                    pre.next[1].val=1;
                    pre = pre.next[1];
                    pre.ctr++;
                }
            }
        }

        private int queryTrieNode(int curr) {
            TrieNode pre = root;
            int ret = 0;
            for(int i=31;i>=0;i--){
                if(((curr>>i)&1)==0){
                    if(pre.next[1]!=null&&pre.next[1].ctr>0) {
                        pre = pre.next[1];
                        ret|=1<<i;
                    }
                    else{
                        pre = pre.next[0];
                    }
                }
                else{
                    if(pre.next[0]!=null&&pre.next[0].ctr>0) {
                        pre = pre.next[0];
                        ret|=1<<i;
                    }
                    else{
                        pre = pre.next[1];
                    }
                }
            }
            return ret;
        }

        void removeTrieNode(int curr){
            TrieNode pre = root;
            for(int i=31;i>=0;i--){
                if(((curr>>i)&1)==0){
                    pre = pre.next[0];
                    pre.ctr--;
                }
                else{
                    pre = pre.next[1];
                    pre.ctr--;
                }
            }
        }



        class TrieNode{
            int val;
            int ctr;
            TrieNode[] next = new TrieNode[2];
        }
    }

    public static void main(String[] args) {
//       [3,7,-1,2,0,7,0,2]
//[[4,6],[1,15],[0,5]]
        int[] parents = new int[]{3,7,-1,2,0,7,0,2};
        int[][] queries = new int[][]{{1,15 }};
        int[] ret = (int[]) RunUtil.run(parents,queries);
        System.out.println(Arrays.toString(ret));
    }
}

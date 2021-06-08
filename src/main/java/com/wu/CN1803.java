package com.wu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2021/3/29 17:56
 */
public class CN1803 {
    class Solution {
        public int countPairs(int[] nums, int low, int high) {
            TrieNode root = new TrieNode();
            int ret = 0;
            for (int num : nums) {
                ret += smaller(root,num,high+1)-smaller(root,num,low);
                insert(root,num);
            }
            return ret;
        }

        void insert(TrieNode root,int num){
            TrieNode curr = root;
            for(int i=31;i>=0;i--){
                int index= ((num>>i)&1);
                if(curr.children[index]==null){
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
                curr.count++;
            }
        }

        private int smaller(TrieNode root, int num, int low) {
            TrieNode curr = root;
            int ret = 0;
            for(int i=31;i>=0;i--){
                int index_low = ((low>>i)&1);
                int index= ((num>>i)&1);
                if(index_low==0){
                    if(curr.children[index]==null)break;
                    else curr = curr.children[index];
                }
                else{
                    if(curr.children[index]!=null)ret+=curr.children[index].count;
                    if(curr.children[1-index]!=null)curr = curr.children[1-index];
                    else break;
                }
            }
            return ret;
        }

        private class TrieNode {
            int count = 0;
            TrieNode[] children = new TrieNode[2];
        }
    }
}

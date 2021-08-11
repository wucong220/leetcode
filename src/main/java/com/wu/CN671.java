package com.wu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author wuc006
 * @date 2021/7/27 14:17
 */
public class CN671 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        TreeSet<Integer> pq = new TreeSet<>(Comparator.reverseOrder());
        public int findSecondMinimumValue(TreeNode root) {
            if(root==null)return -1;
            pq.add(root.val);
            if(pq.size()>2)pq.pollFirst();
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
            if(pq.size()==2)return pq.first();
            else{
                return -1;
            }
        }
    }
}

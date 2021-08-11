package com.wu;

import lombok.val;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/7/31 11:51
 */
public class CN987 {
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
        Map<Integer, Map<Integer, PriorityQueue<TreeNode>>> colRowMap = new TreeMap<>();
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            traverse(root,0,0);
            List<List<Integer>> ret = new ArrayList<>();
            for (Map.Entry<Integer, Map<Integer, PriorityQueue<TreeNode>>> col : colRowMap.entrySet()) {
                List<Integer> list = new ArrayList<>();
                ret.add(list);
                final Map<Integer, PriorityQueue<TreeNode>> colValue = col.getValue();
                for (Map.Entry<Integer, PriorityQueue<TreeNode>> row : colValue.entrySet()) {
                    final PriorityQueue<TreeNode> value = row.getValue();
                    while(!value.isEmpty()){
                        list.add(value.poll().val);
                    }
                }
            }
            return ret;
        }

        private void traverse(TreeNode root, int col, int row) {
            if(root==null)return;
            colRowMap.putIfAbsent(col,new TreeMap<>());
            colRowMap.get(col).putIfAbsent(row,new PriorityQueue<>(Comparator.comparing(a->a.val)));
            colRowMap.get(col).get(row).offer(root);
            traverse(root.left,col-1,row+1);
            traverse(root.right,col+1,row+1);
        }
    }
}

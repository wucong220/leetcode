package com.wu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/5/7 10:16
 */
public class CN199 {
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
        public List<Integer> rightSideView(TreeNode root) {
            LinkedList<TreeNode> q = new LinkedList<>();
            q.push(root);
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()){
                int qSize = q.size();
                TreeNode right = null;
                for(int i=0;i<qSize;i++){
                    TreeNode poll = q.poll();
                    right=poll;
                    if(poll.left!=null)q.offer(poll.left);
                    if(poll.right!=null)q.offer(poll.right);
                }
                list.add(right.val);
            }
            return list;
        }
    }
}

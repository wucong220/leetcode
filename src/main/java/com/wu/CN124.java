package com.wu;

/**
 * @author wuc006
 * @date 2021/4/23 19:03
 */
public class CN124 {
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
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            maxPathThruRoot(root);
            return max;
        }

        public int maxPathThruRoot(TreeNode root){
            if(root==null)return 0;
            int left = maxPathThruRoot(root.left);
            int right = maxPathThruRoot(root.right);
            max = Math.max(left,left+right+root.val);

            int tempMax = Math.max(root.val+left,root.val+right);
            return Math.max(tempMax, 0);
        }
    }
}

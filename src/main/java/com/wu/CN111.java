package com.wu;

/**
 * @author wuc006
 * @date 2020/8/21 11:22
 */
public class CN111 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int minDepth(TreeNode root) {
            if(root==null)
                return 0;
            else{
                if(root.left!=null&&root.right!=null)
                    return 1+Math.min(minDepth(root.left),minDepth(root.right));
                else if(root.left!=null)
                    return 1 + minDepth(root.left);
                else if (root.right!=null)
                    return 1 + minDepth(root.right);
                else {
                    return 1;
                }
            }
        }
    }
}

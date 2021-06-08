package com.wu;

import java.util.Arrays;

/**
 * @author wuc006
 * @date 2021/5/7 16:40
 */
public class CN105 {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length==0)return null;
            TreeNode root = new TreeNode(preorder[0]);
            for(int i=0;i<inorder.length;i++){
                if(inorder[i]==preorder[0]){
                    root.left = buildTree(Arrays.copyOfRange(preorder,1,1+i),Arrays.copyOfRange(inorder,0,i));
                    root.right = buildTree(Arrays.copyOfRange(preorder,1+i,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
                }
            }
            return root;
        }
    }
}

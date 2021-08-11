package com.wu;

import com.wu.TreeNode;


class Solution {
    boolean findp=false;
    boolean findq=false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        TreeNode lNode = lowestCommonAncestor(root.left, p, q);
        if(lNode!=null)return lNode;
        TreeNode rNode = lowestCommonAncestor(root.right, p, q);
        if(rNode!=null)return rNode;
        if(root==p)findp = true;
        if(root==q)findq = true;
        if(findp&&findq)return root;
        return null;
    }
}
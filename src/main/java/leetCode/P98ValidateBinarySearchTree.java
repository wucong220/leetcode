package leetCode;

import DataStructure.TreeNode;

public class P98ValidateBinarySearchTree {
	public long value = Integer.MIN_VALUE-1;
	
    public boolean isValidBST(TreeNode root) {
    	if(root==null)return true;
    	return preOrderTravesal(root);
    }
    
    public boolean preOrderTravesal(TreeNode root){
    	boolean left = true;
    	boolean right = true;
    	if(root.left!=null){
    		left = preOrderTravesal(root.left);
    	}
    	
    	if(root.val<=value)return false;
    	else value = root.val;
    	
    	if(root.right!=null){
    		right = preOrderTravesal(root.right);
    	}
    	return left&&right;
    }
}

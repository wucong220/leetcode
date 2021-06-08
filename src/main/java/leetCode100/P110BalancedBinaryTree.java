package leetCode100;

import DataStructure.TreeNode;

public class P110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        
    	int[] left = isBalancedAndDepth(root.left);
    	int[] right = isBalancedAndDepth(root.right);
    	if(left[0]==1&&right[0]==1&&Math.abs(left[1]-right[1])<=1)return true;
    	return false;
    }
    
    public int[] isBalancedAndDepth(TreeNode root){
    	int[] ret = new int[2];
    	if(root==null){
    		ret[0]=1;
    		ret[1]=0;
    		return ret;
    	}
    	int[] left = isBalancedAndDepth(root.left);
    	int[] right = isBalancedAndDepth(root.right);
    	if(left[0]==1&&right[0]==1&&Math.abs(left[1]-right[1])<=1){
    		ret[0] = 1;
    		ret[1] = (left[1]+right[1]+1)/2+1;
    		return ret;
    	}
    	return ret;
    }
    
}

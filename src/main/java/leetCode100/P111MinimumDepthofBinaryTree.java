package leetCode100;

import DataStructure.TreeNode;

public class P111MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root){
		return minDepth(root,1);
	}
	
	public int minDepth(TreeNode root,int level){
		
		int left=Integer.MAX_VALUE;
		int right=Integer.MAX_VALUE;
		
		if(root.left==null&&root.right==null)
		return level;
		
		if(root.left!=null)
			left = minDepth(root.left,level+1);
		if(root.right!=null)
			right = minDepth(root.right,level+1);
		
		
		return Math.min(left, right);
	}
}

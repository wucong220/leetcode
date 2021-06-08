package leetCode100;

import DataStructure.TreeNode;

public class P104MaximumDepthOfBinaryTree {
	public int max=0;
	public int maxDepth(TreeNode root){
		maxDepth(root,1);
		return max;
	}
    public int maxDepth(TreeNode root,int level) {
    	
    	if(level>max)max=level;
    	if(root.left!=null)maxDepth(root.left,level+1);
    	
    	if(root.right!=null)maxDepth(root.left,level+1);
        return 0;
    }
}

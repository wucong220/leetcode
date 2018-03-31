package leetCode100;

import DataStructure.TreeNode;

public class P124BinaryTreeMaximumPathSum {
	
	//Time Limit Exceeded;
	//二叉树的最长路径和问题
	
	
	//这个最长路径必定是通过某个根节点的一条路径
	//所以我们可以遍历所有的节点，并且得到以该节点为根节点的子树的最长路径、
	//这个最长路径就是这个节点到左子树的叶子节点的最长路径加上这个节点到右子树的叶子节点的最长路径。
	
	public int maxPathSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    	
    	maxPathSum1(root);
    	
    	return maxPathSum;
    }
    
    //从写一个函数，这个函数返回的是该节点到叶子节点的最长路径;
    public int maxPathSum1(TreeNode root){
    	int ret =0;
    	if(root==null) return 0;
    	
    	int left =maxPathSum1(root.left);
    	int right = maxPathSum1(root.right);
    	ret = Math.max(left,right)+root.val;
    	int maxpathsum =left+right+root.val;
    	maxPathSum = Math.max(maxpathsum, maxPathSum);
    	
    	if(ret<0)ret=0;
    	return ret;
    }
    
    public static void main(String[] args) {
	
	}
}

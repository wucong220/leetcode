package leetCode100;

import DataStructure.TreeNode;

public class P108ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    
    public TreeNode buildTree(int[] nums,int low,int high){
    	if(low>high){
    		return null;
    	}
    	int mid = low + (high-low)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	
    	root.left = buildTree(nums,low,mid-1);
    	root.right = buildTree(nums,mid+1,high);
    	
    	return root;
    }
}

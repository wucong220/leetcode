package leetCode100;

import DataStructure.TreeNode;

public class P114FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        flattenR(root);
    }
    public  TreeNode[] flattenR(TreeNode root){
    	if(root==null)return null;
    	
    	TreeNode[] ret = new TreeNode[2];	
    	TreeNode[] left = flattenR(root.left);
    	TreeNode[] right = flattenR(root.right);
    	
    	ret[0]=root;
    	if(left!=null&&right!=null){
    		root.right = left[0];
    		left[1].right =right[0];
    		ret[1] = right[1];
    	}
    	else if(left!=null){
    		root.right = left[0];
    		ret[1]=left[1];
    	}
    	else if(right!=null){
    		root.right = right[0];
    		ret[1] = right[1];
    	}else{
    		ret[1]=root;
    	}
    	
    	return ret;
    }
}

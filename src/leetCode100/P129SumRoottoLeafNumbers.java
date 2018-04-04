package leetCode100;

import DataStructure.TreeNode;

public class P129SumRoottoLeafNumbers {
    int sum=0;
	public int sumNumbers(TreeNode root) {
        
		
		sumNumbers(root,0);
    	return sum;
    }
	
	public void sumNumbers(TreeNode root,int parentValue){
		root.val = parentValue*10+root.val;
		
		if(root.left==null&&root.right==null){
			sum += root.val;
		}
		
		if(root.left!=null){
			sumNumbers(root.left,root.val);
		}
		if(root.right!=null){
			sumNumbers(root.right,root.val);
		}
		
		
	}
}

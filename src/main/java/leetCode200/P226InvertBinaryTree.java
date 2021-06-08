package leetCode200;

import java.util.Stack;

import DataStructure.TreeNode;

public class P226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
    	Stack<TreeNode> s = new Stack<>();
    	TreeNode ori =root;
    	while(true){
    		if(root!=null){
	    		TreeNode temp = root.left;
	    		root.left = root.right;
	    		root.right = temp;
	    		s.push(root.right);
	    		root = root.left;
    		}
    		else{
    			if(s.isEmpty())break;
    			root = s.pop();
    		}
    	}
        return ori;
    }
	public static void main(String[] args) {
		
	}
}

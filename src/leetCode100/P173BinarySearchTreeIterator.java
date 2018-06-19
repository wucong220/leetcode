package leetCode100;

import java.util.Stack;

import DataStructure.TreeNode;

public class P173BinarySearchTreeIterator {

}

class BSTIterator {
	TreeNode curr;
	Stack<TreeNode> s;
	
    public BSTIterator(TreeNode root) {
        curr = root;
        s= new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	while(true){
    		if(curr==null){
    			if(s.empty())return false;
    			return true;
    		}
    		else{
    			if(curr.left==null){
    				return true;
    			}
    			else{
    				s.push(curr);
    				curr = curr.left;
    			}
    		}
    	}
    }

    /** @return the next smallest number */
    public int next() {
    	int ret=0;
    	while(true){
    		if(curr==null){
    			if(s.empty())break;
                curr = s.pop();
    			ret = curr.val;
    			curr = curr.right;
    			return ret;
    		}
    		else{
    			if(curr.left==null){
    				ret = curr.val;
    				curr = curr.right;
    				return ret;
    			}
    			else{
    				s.push(curr);
    				curr = curr.left;
    			}
    		}
    	}
    	return ret;
    }
    
//    private void BTInorderTravesal(TreeNode root){
//    	Stack<TreeNode> s = new Stack<TreeNode>();
//    	while(true){
//    		if(root==null){
//    			if(s.empty())break;
//    			root=s.pop();
//    			System.out.println(root.val);
//    			root=root.right;
//    		}
//    		else{
//    			if(root.left==null){
//    				System.out.println(root.val);
//    				root=root.right;
//    			}
//    			else{
//    				s.push(root);
//    				root = root.left;
//    			}
//    		}
//    	}
//    }
}

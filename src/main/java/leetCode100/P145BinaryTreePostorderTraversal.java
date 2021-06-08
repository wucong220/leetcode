package leetCode100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import DataStructure.TreeNode;

public class P145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
       
        while(true){
        	if(root==null){
        		if(s.empty())break;
        		root = s.pop();
        		root = root.left;
        	}
        	else{
        		if(root.right!=null){
        			s.push(root);
        			root = root.right;
        		}
        		else {
        			root = root.left;
        		}
        	}
        }
        Collections.reverse(ret);
        
        
        return ret;
    }
}	

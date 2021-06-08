package leetCode100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DataStructure.TreeNode;

public class P107BinaryTreeLevelOrderTraversalII {
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> ret = levelOrder(root);
    	Collections.reverse(ret);
    	return ret;
    }
    
    
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ret = new ArrayList<>();
    	if(root==null) return ret;
    	levelOrder(ret, root, 1);
    	return ret;
    }
    
    public void levelOrder(List<List<Integer>> ret,TreeNode root,int level){
    	
    	if(ret.size()<level){
    		List<Integer> l = new ArrayList<Integer>();
        	l.add(root.val);
    		ret.add(l);
    	}else{
    		List<Integer> l = ret.get(level-1);
    		l.add(root.val);
    	}
    	if(root.left!=null)
    		levelOrder(ret,root.left,level+1);
    	if(root.right!=null){
    		levelOrder(ret,root.right,level+1);
    	}
    	
    	
    	
    }
}

package leetCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DataStructure.TreeNode;

public class P113PathSumII {
    public boolean hasPathSum(TreeNode root,int sum){
        if(root==null)return false;
    	if(root.val==sum&&root.right==null&&root.left==null)return true;
    	return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null)return ret;
        if(root.val==sum&&root.right==null&&root.left==null){
        	List<Integer> l =  new ArrayList<Integer>();
        	l.add(root.val);
        	ret.add(l);
        }
        
        List<List<Integer>> left;
        List<List<Integer>> right;
        if(root.left!=null){
        	left = pathSum(root.left,sum-root.val);
        	for (List<Integer> list : left) {
				list.add(0,root.val);
				ret.add(list);
			}
        }
        if(root.right!=null){
        	right = pathSum(root.right,sum-root.val);
        	for (List<Integer> list : right) {
				list.add(0,root.val);
				ret.add(list);
			}
        }
    	
    	return ret;
    }
}

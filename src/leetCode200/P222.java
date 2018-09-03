package leetCode200;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import DataStructure.TreeNode;

public class P222 {
    public int countNodes(TreeNode root) {
    	int level =0;
    	TreeNode right = root;
    	Map<TreeNode,Integer> le = new HashMap<>();
    	while(right!=null){
    		level++;
    		right=right.right;
    	}
    	int leftLevel=0;
    	Deque<TreeNode> stack = new LinkedList<>();
    	TreeNode left = root;
    	while(left!=null){
    		leftLevel++;
    		le.put(left, leftLevel);
    		stack.push(left);
    		left=left.left;
    	}
    	
    	if(leftLevel==level)return (int) Math.pow(2, level)-1;
    	else return countNodes(root.left)+countNodes(root.right)+1;	
    }
}

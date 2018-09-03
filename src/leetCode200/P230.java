package leetCode200;

import java.util.Deque;
import java.util.LinkedList;

import DataStructure.TreeNode;

public class P230 {
	TreeNode getNext(TreeNode curr,Deque<TreeNode> stack){
		if(curr.right!=null){
			curr = curr.right;
			while(curr.left!=null){
				stack.push(curr);
				curr=curr.left;
			}
			return curr;
			
		}
		else{
			if(stack.isEmpty())return null;
			else{
				TreeNode p=null;
				while(!stack.isEmpty()&&(p=stack.pop()).val<curr.val){
				}
				return p;
			}
		}
	}
	
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while(curr.left!=null){
        	stack.push(curr);
        	curr=curr.left;
        }
        if(k==1)return curr.val;
        for(int i=0;i<k-1;i++){
        	curr = getNext(curr, stack);
        }
    	return curr.val;
    }
}

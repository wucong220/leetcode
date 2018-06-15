package leetCode100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DataStructure.TreeNode;

public class P144BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();		
		while (true) {
			if(root==null){
				if(s.isEmpty())break;
				root=s.pop();
				root=root.right;
			}
			else{
				ret.add(root.val);
				if(root.left!=null){
					s.push(root);  //只有遍历左子树之前，才需要压栈。因为要遍历右子树。
					root=root.left;
				}
				else{
					root=root.right;
				}
			}

		}

		return ret;
	}
}

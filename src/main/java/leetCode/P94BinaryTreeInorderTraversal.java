package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import DataStructure.TreeNode;

public class P94BinaryTreeInorderTraversal {
	// inorder traversal 中序遍历 Recursive solution is trivial, could you do it
	// iteratively?
	static public List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		if (root == null)
			return l;

		if (root.left != null) {
			l.addAll(inorderTraversalRecursive(root.left));
		}

		l.add(root.val);

		if (root.right != null) {
			l.addAll(inorderTraversalRecursive(root.right));
		}

		return l;
	}

	static public List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> l = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();

		TreeNode ptr = root;

		while(true){
			if(ptr!=null){
				s.push(ptr);
				ptr = ptr.left;
			}
			else{
				if(s.empty())break;
				ptr = s.pop();
				l.add(ptr.val);
				ptr=ptr.right;
			}
		}

		return l;
	}

	public static void main(String[] args) {
		
	}
}

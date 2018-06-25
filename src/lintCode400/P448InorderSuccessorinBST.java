package lintCode400;

import java.util.LinkedList;
import java.util.Stack;

import DataStructure.TreeNode;

public class P448InorderSuccessorinBST {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		// write your code here

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode curr = root;
		while (true) {
			if (curr == null) {
				return null;
			} else {
				int compareResult = p.val - curr.val;
				if (compareResult == 0) {
					if (curr.right != null) {
						curr = curr.right;
						while (curr.left != null)
							curr = curr.left;
						return curr;
					} else {
						while (!s.isEmpty()) {
							TreeNode parent = s.pop();
							if (parent.val > p.val) {
								return parent;
							}
						}
						return null;
					}
				} else if(compareResult <0) {
					s.push(curr);
					curr=curr.left;
				} else{
					curr=curr.right;
				}
			}
		}
	}
}

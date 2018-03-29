package leetCode100;

import DataStructure.TreeLinkNode;

public class P116PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
        if(root==null)return;
		TreeLinkNode left = null, right = null;
		if (root.left != null) {
			left = root.left;
			right = root.right;
            left.next = right;
			while (left.right != null) {
				left = left.right;
				right = right.left;
                left.next = right;
			}
            connect(root.left);
		    connect(root.right);  
		}
	}
}

// 这道题感觉有点小麻烦；
// 不好使用递归来解，不好把大问题化为小问题
// 为什么题目要强调这个树是一个完美二叉树呢？
// 完美的让人心惊胆颤。
// 我突然灵光一现，
// 对某一个根节点，可以先将他的左右子树连接在一起。
/*
 * 同时将左子树的右边的节点和右子树左边节点连接在一起。
 * 还是他妈要递归。。。。二叉树的对称性导致二叉树很适合用递归
 */
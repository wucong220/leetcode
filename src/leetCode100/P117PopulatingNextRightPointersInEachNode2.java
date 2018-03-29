package leetCode100;

import DataStructure.TreeLinkNode;

public class P117PopulatingNextRightPointersInEachNode2 {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode left = null, right = null;
		connect(root.left);
		connect(root.right);
		// 左右两子树自身已经连接完毕了
		if (root.left != null && root.right != null) {
			// 连接两子树的根节点
			left = root.left;
			right = root.right;

			while (true) {
				TreeLinkNode mostleftofleft = null, mostleftofright = null, mostleftorightcurr = right;
				// 将左右两子树下一层的最左节点找到
				while (true) {
					if (left.left != null) {
						mostleftofleft = left.left;break;
					} else if (left.right != null) {
						mostleftofleft = left.right;break;
					} else {
						if (left.next != null) {
							left = left.next;
						} else {
							break;
						}
					}
				}
				while(true){
					if (right.left != null) {
						mostleftofright = right.left;break;
					} else if (right.right != null) {
						mostleftofright = right.right;break;
					} else {
						if (right.next != null) {
							right = right.next;
						} else {
							break;
						}
					}
				}
				// 找到本层的左子树最右节点；连接到右子树的最左节点；
				while (left.next != null)
					left = left.next;
				left.next = mostleftorightcurr;
				left = mostleftofleft;
				right = mostleftofright;

				// 若是某一个子树的某一层为空，即可停止链接
				if (mostleftofleft == null || mostleftofright == null)
					break;
			}

		}
	}
}
/*
 * 这道题是在前面一道题的基础之上，去掉了一个限定条件；二叉树为任意二叉树，而不是一个完美二叉树。 意味着不能照搬前一题的算法，但是思想应该也差不多。
 * 只需要想办法将左右两个子树连接在一起即可？ 因为不是完美二叉树了， 就不能无脑连接。 只能将同层的左子树最右节点，和右子树的最左节点连接。
 * 但是又不能通过简单的循环查找要连接的节点，比如说一棵树 1 1 1 1 # 1 1 ￥ 我们在找右子树的最左节点的时候，掉进左边的
 * #节点就会遗漏右下角的￥。 如果二叉树是阶梯状的，那开销会大的一批。 可以考虑写一个函数来专门返回某一层的最左节点，最坏情况可能要遍历整个树。
 * 这种方法感觉很复杂；
 * 
 * 还是要使用分而治之的办法，假定子树已经连接好了的情况，大树要怎么处理。
 * 若是子树自身是连接好了的话，那么要找上面所述的那两类节点顺着已经连接好了线路就会很容易。
 *
 * 
 * 
 */
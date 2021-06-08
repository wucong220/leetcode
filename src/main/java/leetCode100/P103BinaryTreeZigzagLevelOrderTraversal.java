package leetCode100;

import java.util.ArrayList;
import java.util.List;

import DataStructure.TreeNode;

public class P103BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		zigzagLevelOrder(ret, root, 1);
		return ret;
	}

	public void zigzagLevelOrder(List<List<Integer>> ret, TreeNode root, int level) {

		if (ret.size() < level) {
			List<Integer> l = new ArrayList<Integer>((int) Math.pow(2, level - 1));
			l.add(root.val);
			ret.add(l);
		} else {
			if (level % 2 == 0) {
				List<Integer> l = ret.get(level - 1);
				l.add(0, root.val);
			} else {
				List<Integer> l = ret.get(level - 1);
				l.add(root.val);
			}
		}
		if (root.left != null)
			zigzagLevelOrder(ret, root.left, level + 1);
		if (root.right != null) {
			zigzagLevelOrder(ret, root.right, level + 1);
		}

	}
}

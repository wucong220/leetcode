package leetCode200;

import java.util.ArrayList;
import java.util.List;

import DataStructure.TreeNode;

public class P236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pathP = new ArrayList<>();
		List<TreeNode> pathQ = new ArrayList<>();
		boolean[] flag = new boolean[2];
		dfs(pathP, pathQ, root, p, q, flag);
		int i=0;
		for(i=0;i<pathP.size()&&i<pathQ.size();i++){
			if(pathP.get(i)!=pathQ.get(i))break;
		}
		return pathP.get(i-1);
		
	}

	public void dfs(List<TreeNode> pathP, List<TreeNode> pathQ, TreeNode root, TreeNode p, TreeNode q, boolean[] flag) {
		if (!flag[0])
			pathP.add(root);
		if (!flag[1])
			pathQ.add(root);

		if (root == p) {
			flag[0] = true;
		}
		if (root == q) {
			flag[1] = true;
		}
		
		if (root.left != null)
			dfs(pathP, pathQ, root.left, p, q, flag);
		if (root.right != null) 
			dfs(pathP, pathQ, root.right, p, q, flag);
		
		if (!flag[0])
			pathP.remove(pathP.size() - 1);
		if (!flag[1])
			pathQ.remove(pathQ.size() - 1);

	}
}

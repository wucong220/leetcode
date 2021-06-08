package leetCode;

import java.util.ArrayList;
import java.util.List;

import DataStructure.TreeNode;

public class P95GeneratedTrees {
	static public List<TreeNode> generateTrees(int n) {
		return generateTrees(1, n);
	}

	static public List<TreeNode> generateTrees(int m, int n) {
		
		List<TreeNode> ret = new ArrayList<>();
		if(m==n){ret.add(new TreeNode(m));return ret;}
		if(m+1==n){
			TreeNode head = new TreeNode(m);
			head.right=new TreeNode(n);
			ret.add(head);
			head = new TreeNode(n);
			head.left=new TreeNode(m);
			ret.add(head);
			return ret;
		}
		for (int i = m; i <= n; i++) {
			List<TreeNode> lSubtrees = null;
			List<TreeNode> rSubtrees = null;
			if (i > m) {
				lSubtrees = generateTrees(m, i - 1);
			}
			if (i < n) {
				rSubtrees = generateTrees(i + 1, n);
			}
			if(i<n&&i>m){
				for (TreeNode rnode : rSubtrees) {
					for (TreeNode lnode : lSubtrees) {
						TreeNode head = new TreeNode(i);
						head.left = lnode;
						head.right =rnode;
						ret.add(head);
					}
				}
			}
			else if(i==n){
				for (TreeNode lnode : lSubtrees) {
					TreeNode head = new TreeNode(i);
					head.left = lnode;
					ret.add(head);
				}
			}	
			else if(i==m){
				for (TreeNode rnode : rSubtrees) {
					TreeNode head = new TreeNode(i);
					head.right = rnode;
					ret.add(head);
				}				
			}
			System.out.println("m:"+m+", "+"n:"+n+"\n"+ret);
			
		}
		return ret;
	};
	
	public static void main(String[] args) {
		System.out.println(generateTrees(3));
	}
}

package leetCode100;

import DataStructure.TreeNode;

public class P101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricTree(root.left,root.right);
    }
    
	public boolean isSymmetricTree(TreeNode p, TreeNode q) {

		if (p == null && q == null)
			return true;
		else if (p != null && q != null) {
			if (p.val != q.val)
				return false;
			else
				return isSymmetricTree(p.left,q.right)&&isSymmetricTree(p.right, q.left);
		}
		else return false;
	}
	
	public static void main(String[] args) {
		
	}
}

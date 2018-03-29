import DataStructure.TreeNode;

public class P112PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)return false;
    	if(root.val==sum&&root.right==null&&root.left==null)return true;
        if(root.val>sum)return false;  	
    	return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}

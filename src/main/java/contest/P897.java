package contest;

import DataStructure.TreeNode;

public class P897 {
    static public TreeNode increasingBST(TreeNode root) {
        TreeNode left = root.left!=null?increasingBST(root.left):null;
        TreeNode l =left;
        root.left=null;
        if(l!=null){
            while(l.right!=null){
                l=l.right;
            }
            l.right=root;
        }
        else{
            left = root;
        }
        
        root.right = root.right!=null?increasingBST(root.right):null;
        
        return left;
    }
    public static void main(String[] args) {
    	String input = "[5,3,6,2,4,null,8,1,null,null,null,7,9]";
		String s =TreeNode.treeNodeToString(increasingBST(TreeNode.stringToTreeNode(input)));
		System.out.println(s);
	}
    
}

package offer;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
    
    //树转化为链表
    public TreeNode Convert(TreeNode root) {
    	
    	TreeNode rleft=null;
    	TreeNode rright=null;
    	if(root.left!=null){
    		rleft = Convert(root.left);
    	}
    	
    	if(root.right!=null){
    		rright = Convert(root.right);
    	}
    	
    	
    	TreeNode ptr = root;
    	
    	if(rleft!=null){
    		ptr = rleft;
    		while(ptr.right!=null){
    			ptr = ptr.right;
    		}
    		ptr.right =root;
    		root.left = ptr;
    		ptr = root;
    		root = rleft;
    	}
    	
    	
    	if(rright!=null){
    		rright.left =ptr;
    		ptr.right = rright;
    	}
    	
    	return root;
    }
    
    //是否子结构
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null||root1==null)return false;
        if(root1.val==root2.val&&root1.left==null&&root1.right==null&&root2.left==null&&root2.right==null)return true;
        boolean flag = false;
        if(root1.val==root2.val)flag= HasSubtree(root1.left,root2.left)&&HasSubtree(root1.right,root2.right);
        flag = flag||(HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2));
        return flag;
    }
}
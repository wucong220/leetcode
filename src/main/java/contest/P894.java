package contest;

import java.util.ArrayList;
import java.util.List;

import DataStructure.TreeNode;

public class P894 {
    public List<TreeNode> allPossibleFBT(int N) {
	    	List<TreeNode>  ret = new ArrayList<>();
	    	if(N==1){
	    		ret.add(new TreeNode(0));
	    		return ret;
	    	}
	    	for(int i=1;i<=N-2;i++){
	    		List<TreeNode> left = allPossibleFBT(i);
	    		List<TreeNode> right = allPossibleFBT(N-1-i);
	    		for(TreeNode lc:left){
	    			for(TreeNode rc:right){
	    				TreeNode root = new TreeNode(0);
	    				root.left=lc;
	    				root.right=rc;
	    				ret.add(root);
	    			}
	    		}
	    	}
	    	
	    	return ret;
    }
}

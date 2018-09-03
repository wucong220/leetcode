package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import DataStructure.TreeNode;

public class P872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {	
    	return Objects.equals(getLeafSequence(root1),getLeafSequence(root2));
    }
    
    List<Integer> getLeafSequence(TreeNode root){
    	List<Integer> left=null,right=null,ret=new ArrayList<Integer>();
    	if(root.left==null&&root.right==null){
    		ret.add(root.val);
    	}
    	if(root.left!=null){
    		left=getLeafSequence(root.left);
    		ret.addAll(left);
    	}
    	if(root.right!=null){
    		right= getLeafSequence(root.right);
    		ret.addAll(right);
    	}
    	return ret;
    }
}

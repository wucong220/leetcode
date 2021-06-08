package leetCode200;

import java.util.ArrayList;
import java.util.List;

import DataStructure.TreeNode;

public class P235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	TreeNode ptr = root;
    	List<TreeNode> pathP = new ArrayList<>();
    	List<TreeNode> pathQ = new ArrayList<>();
    	//find p;
    	while(true){
    		pathP.add(ptr);
    		if(p.val<ptr.val){
    			ptr=ptr.left;
    		}
    		else if(p.val>ptr.val){
    			ptr=ptr.right;
    		}
    		else{
    			break;
    		}
    	}
    	ptr = root;
    	while(true){
    		pathQ.add(ptr);
    		if(q.val<ptr.val){
    			ptr=ptr.left;
    		}
    		else if(q.val>ptr.val){
    			ptr=ptr.right;
    		}
    		else{
    			break;
    		}
    	}
        int i=0;
    	for(i=0;i<pathP.size()&&i<pathQ.size();i++){
            System.out.println(pathP.get(i).val+" "+pathQ.get(i).val);
    		if(pathP.get(i)!=pathQ.get(i))break;
    	}
    	return pathP.get(i-1);
    }
}

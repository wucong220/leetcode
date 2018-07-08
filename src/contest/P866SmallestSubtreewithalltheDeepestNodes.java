package contest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import DataStructure.TreeNode;

public class P866SmallestSubtreewithalltheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
    	HashMap<Integer,List<TreeNode>> dMap = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int pcount=0;
        int preCount=1;
        int level = 1;
        dMap.put(level, new ArrayList<TreeNode>());
    	while(!q.isEmpty()){
    		TreeNode curr = q.poll();
    		preCount--;
    		dMap.get(level).add(curr);
    		
    		if(curr.left!=null){
    			pcount++;
    			q.offer(curr.left);
    		}
    		
    		if(curr.right!=null){
    			pcount++;
    			q.offer(curr.right);
    		}
    		
    		
    		if(preCount==0){
    			level++;
    			preCount = pcount;
    			pcount=0;
    			dMap.put(level, new ArrayList<>());
    		}
    	}
    	dMap.remove(level--); //最后一层是空
    	int deepN=dMap.get(level).size();
    	preTraverse(root, 1, level, deepN);
    	return result;
    }
    
    TreeNode result=null;
    int preTraverse(TreeNode root,int level,int deepest,int deepN){

    	int ret = 0;
    	
    	if(deepest==level){
    		ret = 1;
    	}
    	
    	if(root.left!=null){
    		ret += preTraverse(root.left, level+1, deepest,deepN);
    	}
    	
    	if(root.right!=null){
    		ret += preTraverse(root.right, level+1, deepest,deepN);
    	}
    	
    	if(ret==deepN){
    		result = root;
    		ret = 0;
    	}
    	return ret;
    }
    
    
    
}

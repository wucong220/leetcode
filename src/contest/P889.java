package contest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import DataStructure.TreeNode;

public class P889 {
    static public TreeNode constructFromPrePost(int[] pre, int[] post) {
    	for(int i=0;i<post.length/2;i++){
    		int temp = post[i];
    		post[i] = post[post.length-i-1];
    		post[post.length-i-1] = temp;
    	}
    	int[] map_pre = new int[pre.length+1];
    	int[] map_post = new int[post.length+1];
    	for(int i=0;i<pre.length;i++){
    		map_pre[pre[i]]=i;
    		map_post[post[i]]=i;
    	}
    	
    	Queue<TreeNode> q = new LinkedList<>();
    	
    	boolean[] visited = new boolean[pre.length+1];
    	TreeNode root = new TreeNode(pre[0]);
    	if(pre.length==1)return root;
    	q.offer(root);
    	visited[pre[0]]=true;
    	
    	while(!q.isEmpty()){
    		TreeNode curr = q.poll();
    		
    		int index_pre=map_pre[curr.val];
    		int index_post =map_post[curr.val];
    		
    		if(index_pre==pre.length-1||index_post==pre.length-1)continue;
    		
    		if(!visited[pre[index_pre+1]]){
				curr.left = new TreeNode(pre[index_pre+1]);
				q.offer(curr.left);
				visited[pre[index_pre+1]]=true;
	    	}
    		
			if(!visited[post[index_post+1]]&&pre[index_pre+1]!=post[index_post+1]){		
    			curr.right = new TreeNode(post[index_post+1]);
				q.offer(curr.right);
				visited[post[index_post+1]]=true;
			}
    	}
    	return root;
    }
    
    public static void main(String[] args) {
		constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
	}
}

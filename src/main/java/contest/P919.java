package contest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructure.TreeNode;

public class P919 {
	
}

class CBTInserter {
	List<TreeNode> tree;
	TreeNode root;
	
    public CBTInserter(TreeNode root) {
        tree = new ArrayList<TreeNode>();
        Queue<TreeNode> q = new LinkedList<>();
        this.root = root;
        q.offer(root);
        while(!q.isEmpty()){
        	TreeNode node = q.poll();
        	tree.add(node);
        	if(node.left!=null){
        		q.offer(node.left);
        	}
        	if(node.right!=null){
        		q.offer(node.right);
        	}
        }
    }
    
    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        int index = tree.size();
        tree.add(node);
        TreeNode parent = tree.get((index-1)/2);
        if(index%2==0){
        	parent.right = node;
        }
        else parent.left = node;
        return parent.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}
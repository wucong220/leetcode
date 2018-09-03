package leetCode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import DataStructure.TreeNode;

public class P199BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		List<Integer> ret = new ArrayList<>();
		q.offer(root);
		int pcount=0;
		int preCount=1;
		while(!q.isEmpty()){
			TreeNode curr = q.poll();
			preCount--;
			if(curr.left!=null){
				q.offer(curr.left);
				pcount++;
			}
			if(curr.right!=null){
				q.offer(curr.right);
				pcount++;
			}
			if(preCount==0){
				ret.add(curr.val);
				preCount=pcount;
				pcount=0;
			}
		}
		return ret;
    }
}

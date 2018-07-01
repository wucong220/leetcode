package contest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import DataStructure.TreeNode;

public class P863AllNodesDistanceKinBinaryTree {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<TreeNode>> Nodes = getLevelsOfNodes(root);
        List<Integer> ret = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();
        curr.add(target);
        Set<TreeNode> used = new HashSet<>();
        for(int i =0;i<K;i++ ){
        	List<TreeNode> newCurr = new ArrayList<>();
        	for (TreeNode treeNode : curr) {
        		for (TreeNode tn : Nodes.get(treeNode.val)) {
        			if(!used.contains(tn))newCurr.add(tn);
				}
			}
        	used.addAll(curr);
        	curr = newCurr;
        }
        for (TreeNode treeNode : curr) {
			ret.add(treeNode.val);
		}
    	return ret;
    }

	private Map<Integer,List<TreeNode>> getLevelsOfNodes(TreeNode root) {
		// TODO Auto-generated method stub
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		Map<Integer,List<TreeNode>> map = new HashMap<>();
		List<TreeNode> li = new ArrayList<>();
		map.put(root.val,li);
		while(!q.isEmpty()){
			TreeNode curr = q.poll();
			List<TreeNode> pa = map.get(curr.val);
			if(curr.left!=null){
				pa.add(curr.left);
				List<TreeNode> le = new ArrayList<>();
				le.add(curr);
				map.put(curr.left.val,le);
				q.offer(curr.left);
			}
			if(curr.right!=null){
				pa.add(curr.right);
				List<TreeNode> ri = new ArrayList<>();
				ri.add(curr);
				map.put(curr.right.val,ri);
				q.offer(curr.right);
			}
		}
		return map;
	}
}

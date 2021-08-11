package com.wu;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuc006
 * @date 2021/7/30 13:59
 */
public class CN863 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        Map<TreeNode,List<TreeNode>> nextMap = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            traverse(root);
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(target);
            set.add(target);
            for(int i=0;!q.isEmpty();i++){
                int size = q.size();
                for(int j=0;j<size;j++){
                    TreeNode poll = q.poll();
                    for (TreeNode treeNode : nextMap.get(poll)) {
                        if(set.add(treeNode)){
                            q.offer(treeNode);
                        }
                    }
                }
                if(i==k)break;
            }
            return q.stream().map(a->a.val).collect(Collectors.toList());
        }

        private void traverse(TreeNode root) {
            nextMap.putIfAbsent(root,new ArrayList<>());
            if(root.left!=null){
                nextMap.putIfAbsent(root.left,new ArrayList<>());
                nextMap.get(root).add(root.left);
                nextMap.get(root.left).add(root);
                traverse(root.left);
            }
            if(root.right!=null){
                nextMap.putIfAbsent(root.right,new ArrayList<>());
                nextMap.get(root).add(root.right);
                nextMap.get(root.right).add(root);
                traverse(root.right);
            }
        }

    }
}

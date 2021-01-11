package com.wu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuc006
 * @date 2020/12/22 10:12
 */
public class CN103 {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            LinkedList<TreeNode> q=  new LinkedList<>();
            if(root==null)return ret;
            q.offer(root);
            boolean flag = true;
            while(!q.isEmpty()){
                int size = q.size();
                LinkedList<Integer> list = new LinkedList<>();
                for(int i=0;i<size;i++){
                    TreeNode poll;
                    poll=q.poll();
                    list.add(poll.val);

                    if(poll.left!=null)q.offer(poll.left);
                    if(poll.right!=null)q.offer(poll.right);
                }
                if(!flag) Collections.reverse(list);
                ret.add(list);
                flag = !flag;
            }
            return ret;
        }
    }
}

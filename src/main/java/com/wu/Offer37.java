package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/6/30 9:25
 */
public class Offer37 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            List<String> ret = new ArrayList<>();
            q.offer(root);
            while(!q.isEmpty()){
                TreeNode poll = q.poll();
                if(poll!=null) {
                    ret.add(String.valueOf(poll.val));
                    q.offer(poll.left);
                    q.offer(poll.right);
                }
                else{
                    ret.add("n");
                }
            }
            return String.join(",",ret);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            Queue<TreeNode> q = new LinkedList<>();
            if(split[0].equals("n"))return null;
            TreeNode root = new TreeNode(Integer.parseInt(split[0]));
            q.offer(root);
            int i=1;
            while(!q.isEmpty()){
                TreeNode curr = q.poll();
                String left = split[i++];
                String right = split[i++];
                if(!"n".equals(left)){
                    curr.left = new TreeNode(Integer.parseInt(left));
                    q.offer(curr.left);
                }
                if(!"n".equals(right)){
                    curr.right = new TreeNode(Integer.parseInt(right));
                    q.offer(curr.right);
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

    public static void main(String[] args) {

    }
}

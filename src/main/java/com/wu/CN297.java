package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/5/19 10:30
 */
public class CN297 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return null;
        Map<Integer,Integer> map = new HashMap<>();
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        StringJoiner sb = new StringJoiner(",");
        while(!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            if(node==null)sb.add("n");
            else {
                sb.add(String.valueOf(node.val));
                nodes.offer(node.left);
                nodes.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)return null;
        String[] split = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        int curr = 1;
        while(!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            if(!split[curr].equals("n")){
                Integer leftVal = Integer.valueOf(split[curr]);
                node.left = new TreeNode(leftVal);
                nodes.offer(node.left);
            }
            if(!split[curr+1].equals("n")){
                Integer rightVal = Integer.valueOf(split[curr+1]);
                node.right = new TreeNode(rightVal);
                nodes.offer(node.right);
            }
            curr+=2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
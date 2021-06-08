package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/2/21 14:44
 */
public class CN113 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if(root==null)return new ArrayList<>();
            if(root.left==null&&root.right==null){
                if(targetSum==root.val){
                    List<List<Integer>> objects = new ArrayList<>();
                    objects.add(new LinkedList<>(Collections.singletonList(root.val)));
                    return objects;
                }
                else return new ArrayList<>();
            }
            else{
                List<List<Integer>> lists = new ArrayList<>();
                if(root.left!=null) {
                    List<List<Integer>> lists1 = pathSum(root.left, targetSum - root.val);
                    for (List<Integer> list : lists1) {
                        list.add(0, root.val);
                    }
                    lists.addAll(lists1);
                }
                if(root.right!=null) {
                    List<List<Integer>> lists2 = pathSum(root.right, targetSum - root.val);
                    for (List<Integer> list : lists2) {
                        list.add(0, root.val);
                    }
                    lists.addAll(lists2);
                }
                return new ArrayList<>(new HashSet<>(lists));
            }
        }
    }

    public static void main(String[] args) {

    }
}

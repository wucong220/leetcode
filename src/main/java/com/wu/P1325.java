package com.wu;

/**
 * @author wuc006
 * @date 2020/1/21 14:16
 */
public class P1325 {
    class Solution {
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if(root.left!=null){
                removeLeafNodes(root.left,target);
            }
            if(root.right!=null){
                removeLeafNodes(root.right,target);
            }
            if(isLeave(root.left)&&root.left.val==target){
                root.left=null;
            }
            if(isLeave(root.right)&&root.right.val==target){
                root.right=null;
            }
            if(root.left==null&&root.right==null){
                return null;
            }
            return root;
        }
        boolean isLeave(TreeNode node){
            return node!=null&&node.left==null&&node.right==null;
        }
    }
}

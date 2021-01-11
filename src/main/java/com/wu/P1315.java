package com.wu;

/**
 * @author wuc006
 * @date 2020/1/21 16:55
 */
public class P1315 {
    class Solution {
        public int sumEvenGrandparent(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ret = 0;
            if (root.val % 2 == 0) {
                ret += getKidsVal(root.left) + getKidsVal(root.right);
            }
            return ret + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
        }

        int getKidsVal(TreeNode node) {
            int ret = 0;
            if (node != null) {
                if (node.left != null) {
                    ret += node.left.val;
                }
                if (node.right != null) {
                    ret += node.right.val;
                }
            }
            return ret;
        }
    }
}

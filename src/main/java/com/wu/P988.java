package main.java.com.wu;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuc006
 * @date 2019/12/6 12:00
 */
public class P988 {
    class Solution {
        public String smallestFromLeaf(TreeNode node) {
            String[] ptr = new String[2];
            ptr[0]=null;
            dfs(node,ptr);
            return ptr[0];
        }

        public void dfs (TreeNode node,String[] ptr){
            if(ptr[0]==null) {
                ptr[0] = String.valueOf((char)(node.val+'a'));
            }
            else{
                ptr[0]=ptr[0]+String.valueOf((char)(node.val+'a'));
            }

            if(node.left==null&&node.right==null){
                if(ptr[1]==null){
                    ptr[1]=ptr[0];
                }
                else{
                    if(ptr[0].compareTo(ptr[1])<0){
                        ptr[1]=ptr[0];
                    }
                }
            }
            if(node.left!=null){
                dfs(node.left,ptr);
            }
            if(node.right!=null){
                dfs(node.right,ptr);
            }
            ptr[0]=ptr[0].substring(1);
        }
    }

    public static void p(String a){
        a="fukc";
    }
    public static void main(String[] args) {
        String a="666";
        p(a);
        System.out.println(a);
    }
}

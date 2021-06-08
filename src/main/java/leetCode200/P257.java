package leetCode200;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DataStructure.TreeNode;

public class P257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> childs=new ArrayList<>();
        if(root.left==null&&root.right==null){
            childs.add(String.valueOf(root.val));
            return childs;
        }
        if(root.left!=null)
        childs.addAll(binaryTreePaths(root.left));
        if(root.right!=null)
        childs.addAll(binaryTreePaths(root.right));

        childs.replaceAll(a->root.val+a);
        return childs;
    }
    
    public static void main(String[] args) {

	}
}

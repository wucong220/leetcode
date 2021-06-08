package leetCode100;

import java.util.ArrayList;
import java.util.List;

import DataStructure.ListNode;
import DataStructure.TreeNode;

public class P109ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> l = new ArrayList<Integer>();
        while(head!=null){
        	l.add(head.val);
        	head=head.next;
        }
    	
    	return sortedArrayToBST(l.toArray(new Integer[]{}));
    }
    public TreeNode sortedArrayToBST(Integer[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    
    public TreeNode buildTree(Integer[] nums,int low,int high){
    	if(low>high){
    		return null;
    	}
    	int mid = low + (high-low)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	
    	root.left = buildTree(nums,low,mid-1);
    	root.right = buildTree(nums,mid+1,high);
    	
    	return root;
    }
}

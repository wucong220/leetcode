package leetCode100;

import java.util.Arrays;

import DataStructure.TreeNode;

//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]

public class P105ConstructBinaryTreefromPreorderandInorderTraversal {
	public int biSearch(int[] nums, int low, int high, int target) {
		//二分查找只能查找有序数组
//		while (low <= high) {
//			int mid = low + (high - low) / 2;
//			if (target > nums[mid]) {
//				low = mid + 1;
//			} else if (target < nums[mid]) {
//				high = mid - 1;
//			} else
//				return mid;
//		}
		for(int i =low;i<=high;i++){
			if(nums[i]==target)return i;
		}
		
		return -1;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)return null;
		TreeNode root = new TreeNode(preorder[0]);
		
		int ps = 0;// 先序遍历左子树的起始下标（包含）
		int pe = preorder.length;// 先序遍历左子树的终止下标（不包含）

		int is = 0;// 中序遍历左子树的起始下标（包含）
		int ie = inorder.length;// 中序遍历左子树的终止下标（不包含）
		buildTree(root, preorder, ps, pe, inorder, is, ie);
		return root;
	}

	private void buildTree(TreeNode root, int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		int rindex = biSearch(inorder, is, ie - 1, root.val);
		int nps = ps + 1;
		int npe = ps + 1 + rindex - is;
		int nis = is;
		int nie = rindex;
		if (rindex > is) {
			root.left = new TreeNode(preorder[nps]);
			buildTree(root.left, preorder, nps, npe, inorder, nis, nie);
		}
		if(rindex<ie-1){
			root.right = new TreeNode(preorder[npe]);
			buildTree(root.right, preorder, npe, pe, inorder, nie + 1, ie);
		}

	}
	
	public static void main(String[] args) {
		new P105ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
	}
}

package leetCode100;

import DataStructure.TreeNode;

public class P106ConstructBinaryTreeFromInorderandPostorderTraversal {
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

	private void buildTree(TreeNode root, int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		int rindex = biSearch(inorder, is, ie - 1, root.val);
		System.out.println(root.val+","+rindex);
		int nps = pe -1 -(ie-1-rindex); //右子树的开始 (ie - 1- rindex)是右子树的size
		int npe = pe -1 ; //右子树的结束
		int nis = is;
		int nie = rindex;
		if (rindex > is) {
			root.left = new TreeNode(preorder[nps-1]);
			buildTree(root.left, preorder, ps, nps, inorder, nis, nie);
		}
		if(rindex<ie-1){
			root.right = new TreeNode(preorder[npe-1]);
			buildTree(root.right, preorder, nps, npe, inorder, nie + 1, ie);
		}

	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0)return null;
		TreeNode root = new TreeNode(postorder[postorder.length-1]);
		
		int ps = 0;// 后序遍历左子树的起始下标（包含）
		int pe = postorder.length;// 先序遍历左子树的终止下标（不包含）

		int is = 0;// 中序遍历左子树的起始下标（包含）
		int ie = inorder.length;// 中序遍历左子树的终止下标（不包含）
		buildTree(root, postorder, ps, pe, inorder, is, ie);
		return root;
    }
    
	public static void main(String[] args) {
		TreeNode root =new P106ConstructBinaryTreeFromInorderandPostorderTraversal().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
		System.out.println(TreeNode.treeNodeToString(root));
	}
	
}

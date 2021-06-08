package leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import DataStructure.TreeNode;

public class P99RecoverBinarySearchTree {
	
	public void recoverTree(TreeNode root) {

	}

	// Space Complexity O(n)
	public void InOrderTravesalIterative1(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode firstNode = null;
		TreeNode afterNode = null;
		int count = 0;
		int flag = 0;
		long oldValue = Long.MIN_VALUE;

		while (true) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				if (s.empty())
					break;
				root = s.pop();

				if (count == 0)
					if (root.val > oldValue)
						firstNode = root;
					else {
						afterNode = root;
						count = 1;
					}
				else if (root.val <= oldValue) {
					flag = 1;
					int temp = firstNode.val;
					firstNode.val = root.val;
					root.val = temp;
					break;
				}

				oldValue = root.val;
				root = root.right;
			}

		}
		if (flag == 0) {
			int temp = firstNode.val;
			firstNode.val = afterNode.val;
			afterNode.val = temp;
		}
	}

	// Space Complexity O(1) Morris Traversal
	public static void InOrderTravesalIterative(TreeNode root) {


		TreeNode firstNode = null;
		TreeNode afterNode = null;
		int count = 0;
		int flag = 0;
		long oldValue = Long.MIN_VALUE;

		TreeNode prev = null;
		TreeNode curr = root;
		
		while (curr!=null) {
			if (curr.left == null) {
				//=====dosomething
				if (count == 0)
					if (curr.val > oldValue)
						firstNode = curr;
					else {
						afterNode = curr;
						count = 1;
					}
				else if (curr.val <= oldValue) {
					flag = 1;
					int temp = firstNode.val;
					firstNode.val = curr.val;
					curr.val = temp;
					//break;
				}

				oldValue = curr.val;
				//=====
				curr=curr.right;
			}
			else{
				prev = curr.left;
				while(prev.right!=null&&prev.right!=curr)prev=prev.right;
				
				if(prev.right ==null){
					prev.right=curr;
					curr = curr.left;
				}else{
					prev.right=null;
					//=====dosomething
					if (count == 0)
						if (curr.val > oldValue)
							firstNode = curr;
						else {
							afterNode = curr;
							count = 1;
						}
					else if (curr.val <= oldValue) {
						flag = 1;
						int temp = firstNode.val;
						firstNode.val = curr.val;
						curr.val = temp;
						//break; //因爲Morris 改變了原來的樹結構，如果隨便跳出循環會導致，樹的結構還沒有復原
					}

					oldValue = curr.val;
					//=====
					curr=curr.right;
				}
				
			}
		}
		
		if (flag == 0) {
			int temp = firstNode.val;
			firstNode.val = afterNode.val;
			afterNode.val = temp;
		}

	}
	public static void main(String[] args) {
		TreeNode root = stringToTreeNode("[10,5,15,0,8,13,20,2,-5,6,9,12,14,18,25]");
		InOrderTravesalIterative(root);
		System.out.println(treeNodeToString(root));
		
	}

	
	
	
	
	
	
	
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
    
        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }
    
        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
    
            if (node == null) {
              output += "null, ";
              continue;
            }
    
            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }
}




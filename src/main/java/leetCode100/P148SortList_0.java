package leetCode100;

import DataStructure.ListNode;

public class P148SortList_0 {

	// https://leetcode.com/problems/sort-list/discuss/46712/Bottom-to-up(not-recurring)-with-o(1)-space-complextity-and-o(nlgn)-time-complextity
    //今天晚上的雨很大，我很想你。
	//非递归的归并排序
	public ListNode mergeSort(ListNode left,ListNode right){
		if(left==null)return null; //边界条件要周密
		if(left==right){right.next=null;return left;}
		if(left.next==right){
			if(right==null)return left;
			if(left.val<=right.val){
				right.next=null;
				return left;
			}
			else{
				right.next = left;
				left.next = null;
				return right;
			}
		}
		
		ListNode middle = findMiddle(left,right);
		ListNode middlep1 = middle.next; //因为middle会改变，所以middle的后继节点要先保存
		ListNode l1 = mergeSort(left,middle);
		ListNode l2 = mergeSort(middlep1,right);
		return combine(l1,l2);
	}
	
	
	private ListNode combine(ListNode l1, ListNode l2) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0);
		ListNode pos = head;
		while(l1!=null&&l2!=null){
			if(l1.val<=l2.val){pos.next=l1;l1=l1.next;}
			else {pos.next=l2;l2=l2.next;}
			pos=pos.next;
		}
		if(l1!=null){
			pos.next=l1;
		}
		if(l2!=null){
			pos.next=l2;
		}
		return head.next;
	}


	private ListNode findMiddle(ListNode left, ListNode right) {
		// TODO Auto-generated method stub
		ListNode walker = left;
		ListNode runner = left;
		while(runner!=right&&runner.next!=right){
			walker = walker.next;
			runner = runner.next.next;
		}
		
		return walker;
	}


	public ListNode sortList(ListNode head) {
        return mergeSort(head, null);
    }
	
	public static void main(String[] args) {
		ListNode.printLinkList(new P148SortList_0().sortList(ListNode.constructALinkList("15243")));
	}
	
}

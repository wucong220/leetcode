package leetCode100;

import DataStructure.ListNode;

public class P147InsertSortedList {
    public static ListNode insertionSortList(ListNode head) {
    	ListNode prehead = new ListNode(Integer.MIN_VALUE);
    	
    	ListNode ptr = head;
    	
    	while(ptr!=null){	
    		ListNode.printLinkList(prehead);
    		ListNode ptr1 = prehead;
    		while(ptr1.next!=null&&ptr1.next.val<ptr.val){
    			ptr1=ptr1.next;
    		}
    		ListNode temp = ptr.next;
    		ptr.next = ptr1.next;
    		ptr1.next =ptr;
    		ptr = temp;
    	}
    	
    	return prehead.next;
    }
    
    public static void main(String[] args) {
		ListNode head =ListNode.constructALinkList("324");
		ListNode.printLinkList(head);
		head=insertionSortList(head);
		ListNode.printLinkList(head);
	}
}

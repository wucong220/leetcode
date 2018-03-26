package leetCode;

import DataStructure.ListNode;

public class P92ReverseLinkedListII {
    static public ListNode reverseBetween(ListNode head, int m, int n) {
        //node_m->after_n ;beafore_m->n;
    	if(head==null||head.next==null)return head;
    	ListNode before_m;
    	ListNode after_n;
    	ListNode node_m;
    	ListNode node_n = null;
    	
    	ListNode phead = new ListNode(0);
    	phead.next = head;
    	ListNode ptr = phead;
    	for(int i = 0 ;i<m-1;i++){
    		ptr=ptr.next;
    	}
    	before_m = ptr;
    	node_m = ptr.next;
    	ptr = ptr.next; // ptr = node_m;
    	
    	ListNode temp=null;
    	for(int i=m;i<=n;i++){
    	ListNode next = ptr.next;	
    		if(temp!=null)ptr.next = temp;
    		temp = ptr;
    		if(i==n)node_n = ptr;
    		ptr = next;
    	}
    	after_n = ptr;
    	
    	node_m.next = after_n;
    	before_m.next = node_n;
    	
    	
    	return phead.next;
    }
    
    public static void main(String[] args) {
		ListNode head = ListNode.constructALinkList("12345");
		head = reverseBetween(head, 2, 4);
		ListNode.printLinkList(head);
	}
}

package leetCode200;

import DataStructure.ListNode;

public class P206ReverseLinkedList {
    static public ListNode reverseList(ListNode head) {
    	if(head==null)return null;
        
        ListNode pre,curr;
        pre = head;
        curr= head.next;
        while(curr!=null){
        	ListNode next = curr.next;
        	curr.next = pre;
        	pre = curr;
        	curr=next;
        }
        head.next=null;
    	return pre;
    }
    
    static public ListNode recursiveReverseList(ListNode head) {
    	return recursiveReverseList(null, head);
    }
    
    static public ListNode recursiveReverseList(ListNode pre,ListNode curr) {
    	if(curr==null)return pre;
    	ListNode next = curr.next;
    	curr.next = pre;
    	return recursiveReverseList(curr,next);
    }
    
    public static void main(String[] args) {
		reverseList(ListNode.constructALinkList("12345"));
	}
}

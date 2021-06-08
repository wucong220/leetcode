package leetCode;

import DataStructure.ListNode;

public class P24SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
    	if(head==null){
    		return null;
    	}
    	ListNode newhead = head.next;
    	if(newhead==null){
    		return head;
    	}
        head.next=newhead.next;
        newhead.next=head;
        ListNode ptr = head.next;
       
        if(ptr!=null){
        	if(head.next.next!=null)
        	head.next=head.next.next;
        	else
        		return newhead;
        }
        
        while(ptr != null){
	    	ListNode temp = ptr.next;
	        ptr.next=temp.next;
	        temp.next=ptr;
	        
	        temp=ptr;
	        ptr=ptr.next;
	        
	        if(ptr!=null){
	        	if(temp.next.next!=null)
	        	temp.next=temp.next.next;
	        	else
	        		break;
	        }
    	}
        
    	return newhead;
    }
    
    public static void main(String[] args) {
		ListNode head = ListNode.constructALinkList("123");
		head = swapPairs(head);
		ListNode.printLinkList(head);
	}
}

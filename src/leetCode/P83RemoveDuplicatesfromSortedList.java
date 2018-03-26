package leetCode;

import DataStructure.ListNode;

public class P83RemoveDuplicatesfromSortedList {
    static public ListNode deleteDuplicates(ListNode head) {
        
    	ListNode ptr = head;
    	ListNode pin_node =head;
    	while(ptr.next!=null){
    		while(ptr.next!=null&&ptr.val==ptr.next.val){
    			ptr=ptr.next;
    		}
    		if(ptr!=null){
    			

    			pin_node.next=ptr.next;
    			pin_node=ptr.next;
    			if(ptr.next!=null)
    			ptr = ptr.next;
    		}
    	}
    	
    	
    	return head;
    }
    
    public static void main(String[] args) {
		ListNode head = ListNode.constructALinkList("112233456");
		ListNode.printLinkList(deleteDuplicates(head));
	}
}

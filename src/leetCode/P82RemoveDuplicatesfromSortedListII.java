package leetCode;

public class P82RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        
    	ListNode ptr = head;
    	ListNode pin_head = head;
    	ListNode pin_node = new ListNode(0);
    	pin_node.next=head;
    	int oldvalue =head.val;
    	int count=1;
    	
    	while(ptr.next!=null){
    		while(ptr.next!=null&&ptr.val==ptr.next.val){
    			ptr=ptr.next;
    		}
    		if(ptr!=null){
    			pin_node.next=ptr.next;
    		}
    	}
    	
    	
    	return null;
    }
}

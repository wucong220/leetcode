package leetCode;

import DataStructure.ListNode;

public class P82RemoveDuplicatesfromSortedListII {
    static public ListNode deleteDuplicates(ListNode head) {
        
    	ListNode ptr = head;
    	ListNode pin_node = new ListNode(0);
    	pin_node.next=head;
    	ListNode headPre = pin_node;
    	int count=1;
    	
    	
    	
    	while(ptr.next!=null){
    		count=0;
    		while(ptr.next!=null&&ptr.val==ptr.next.val){
    			count++;
    			ptr=ptr.next;
    		}
    		if(ptr!=null){
    			
    			if(count==0){
    				pin_node=ptr;
    			}else{
    				pin_node.next=ptr.next;
    			}
    			if(ptr.next!=null)
    			ptr = ptr.next;
    		}
    	}
    	
    	
    	return headPre.next;
    }
    
    public static void main(String[] args) {
		ListNode head = ListNode.constructALinkList("1112233456");
		ListNode.printLinkList(deleteDuplicates(head));
	}
}

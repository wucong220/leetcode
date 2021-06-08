package leetCode200;

import DataStructure.ListNode;

public class P203RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode PhantomHead = new ListNode(0),pre,curr;
    	PhantomHead.next=head;
    	pre = PhantomHead;
    	curr = head;
    	while(curr!=null){
    		if(curr.val==val){
    			pre.next = curr.next;
    		}else{
    			pre = curr;
    		}
    		curr=curr.next;
    	}
    	return PhantomHead.next;
    }
    
    public static void main(String[] args) {
		ListNode.printLinkList(new P203RemoveLinkedListElements().removeElements(ListNode.constructALinkList("11"),1));
	}
}

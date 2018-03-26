package leetCode;

import DataStructure.ListNode;

public class P19RemoveNthNodeFromEndOfList {
    static public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode temp = head;
        int reindex = reindex(temp,n);
        if(reindex!=-1){
        	head=head.next;
        }
    	return head;
    }
    
    static public int reindex(ListNode node,int n){
    	int reindex =0;
    	if(null==node.next){
    		reindex =  1;
    	}
    	else{
    		reindex = reindex(node.next,n);
    		if(reindex==-1)return -1;
    		reindex++;
    	}
    	
    	
    	if(reindex == n+1){
    		node.next=node.next.next;
    		return -1;
    	}
    	
    	return reindex;
    }
    
    public static void main(String[] args) {
		ListNode head = ListNode.constructALinkList("12345");
		ListNode.printLinkList(head);
		head = removeNthFromEnd(head,2);
		ListNode.printLinkList(head);
	}
}

package leetCode;

import DataStructure.ListNode;

public class P25ReverseNodesInK_Group {
    
	static public ListNode reverseLinkList(ListNode pre,ListNode ptr,int size){

		if(pre==ptr){
			return ptr;
		}
		
		ListNode temp = ptr.next;
		ptr.next=pre;
		
		if(size==1){
			return ptr;
		}
		
		return reverseLinkList(ptr,temp,size-1);
	}
	
	static public ListNode findKNext(ListNode ptr,int k){
		ListNode head = ptr;
		while(k>0&&ptr!=null){
			ptr = ptr.next;
			k--;
		}
		if(k>0)return head;
		else return ptr;
	}
	
	static public ListNode getHeadPre(ListNode head,int k){
		
		
		ListNode kNext =findKNext(head, k);
		if(kNext==null){
			return null;
		}
		if(kNext==head){
			return head;
		}
		ListNode pre = reverseLinkList(getHeadPre(kNext, k),kNext,k);
		
		return pre;
		
//		k=2*k-1;
//		while(k>0){
//			ptr = ptr.next;
//			k--;
//		}
//		
//		return ptr;
	}
	
	static public ListNode reverseKGroup(ListNode head, int k) {
        
		ListNode pre = getHeadPre(head,k);
		head = reverseLinkList(pre,head,k);
		
    	return head;
    }
    
    public static void main(String[] args) {
		ListNode head = ListNode.constructALinkList("1234561234567");
		head = reverseKGroup(head,6);
		//head = reverseLinkList(reverseLinkList(null,findKNext(head, 6),6),head,6);
		ListNode.printLinkList(head);
		
		System.out.println();
	}
}

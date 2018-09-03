package leetCode200;

import DataStructure.ListNode;

public class P234 {
    public boolean isPalindrome(ListNode head) {
    	int n=0;
    	ListNode walker = head;
    	ListNode runner = head;
    	ListNode preHead = new ListNode(0);
    	preHead.next=null;
    	
    	while(runner!=null&&runner.next!=null){
    		walker=walker.next;
    		runner=runner.next.next;
    		n++;
    	}
    	
    	
    	
    	
		ListNode ptr = head;
		while(ptr!=walker){
			ListNode t = ptr.next;
			ptr.next=preHead.next;
			preHead.next=ptr;
			ptr=t;
		}
	
    	if(runner==null){
    		ListNode l1 = preHead.next;
    		ListNode l2 = walker;
    		while(l2!=null){
    			if(l1.val!=l2.val)return false;
    		}
    	}
    	else
        {
    		ListNode l1 = preHead.next;
    		ListNode l2 = walker.next;
    		while(l2!=null){
    			if(l1.val!=l2.val)return false;
    		}
    	}
    	
    	return true;   
    	
    }
    public static void main(String[] args) {
		System.out.println(new P234().isPalindrome(ListNode.constructALinkList("11")));
	}
}

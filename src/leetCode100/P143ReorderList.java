package leetCode100;

import DataStructure.ListNode;

public class P143ReorderList {
	
	
	
    public void reorderList(ListNode head) {
    	if(head==null)return;
        ListNode walker = head;
        ListNode runner = head;  
        //找到中点， 和尾点。
    	while(runner.next!=null&&runner.next.next!=null){
    		walker=  walker.next;
    		runner = runner.next.next;
    	}
    	ListNode mid = walker;    	
    	ListNode tail = runner.next==null?runner:runner.next;
    	//从中点往后，将链表倒转
    	ListNode ptr = mid.next;
    	mid.next = null;
    	
    	ListNode old = null;
    	while(ptr!=null){
    		ListNode temp = ptr.next;
    		ptr.next = old;
    		old=ptr;
    		ptr=temp;
    	}
    	ListNode lptr = head;
    	ListNode rptr = tail;
    	while(lptr!=null&&rptr!=null){
    		ListNode templ  =lptr.next;
    		ListNode tempr  =rptr.next;
    		lptr.next = rptr;
    		rptr.next = templ;
    		lptr = templ;
    		rptr = tempr;
    	}
    	
    	return;
    }
	public static void main(String[] args) {
		
	}
}

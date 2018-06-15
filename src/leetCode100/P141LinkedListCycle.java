package leetCode100;

import DataStructure.ListNode;

public class P141LinkedListCycle {
	
	//虽然没有用到额外的空间，但是改变了链表原来的结构
    public boolean ha1sCycle(ListNode head) {
    	
    	ListNode ptr = head;
    	while(ptr!=null){
    		ListNode temp=ptr.next;
    		ptr.next = head;
    		ptr = temp;
    		if(ptr==head)return true;
    	}
    	return false;   
    }

    //正解https://leetcode.com/problems/linked-list-cycle/discuss/44489/O(1)-Space-Solution
    public boolean hasCycle(ListNode head) {
    if(head==null) return false;
    ListNode walker = head;
    ListNode runner = head;
    while(runner.next!=null && runner.next.next!=null) {
        walker = walker.next;
        runner = runner.next.next;
        if(walker==runner) return true;
    }
    return false;
}
}

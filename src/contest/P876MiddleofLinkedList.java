package contest;

import DataStructure.ListNode;

public class P876MiddleofLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while(runner!=null&&runner.next!=null){
        	runner = runner.next.next;
        	walker = walker.next;
        }
        return walker;
    }
}

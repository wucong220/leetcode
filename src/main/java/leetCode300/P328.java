package leetCode300;

import DataStructure.ListNode;

public class P328 {
	public static void main(String[] args) {
		ListNode input = ListNode.constructALinkList("12345");
		ListNode.printLinkList(oddEvenList(input));
	}
    static public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddHead = odd;
        ListNode evenHead = even;
        boolean isEven = true;
        while(head!=null){
            if(isEven){
                odd.next = head;
                odd = head;
                isEven = false;
            }
            else {
                even.next = head;
                even = head;
                isEven= true;
            }
            head = head.next;
        }
        odd.next = evenHead.next;
        return oddHead;
    }
}

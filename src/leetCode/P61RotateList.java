package leetCode;

public class P61RotateList {
    static public ListNode rotateRight(ListNode head, int k) {
    	
    	ListNode head_stored = head;
    	ListNode ptr = head;
    	int count=1;
    	if(head==null)return head;
    	while(ptr.next!=null){
    		ptr=ptr.next;
    		count++;
    	}
    	k= k%count;
    	int fuck =  count-k;
    	ptr.next=head_stored;
    	
    	while(fuck-->0){
    		ptr=ptr.next;
    	}
    	
    	head = ptr.next;
    	ptr.next=null;
    	
    	
    	return head;
    }
    
	public static void main(String[] args) {
		ListNode head = ListNode.constructALinkList("12345");
		ListNode.printLinkList(head);
		head = rotateRight(head, 2);
		ListNode.printLinkList(head);
	}
}

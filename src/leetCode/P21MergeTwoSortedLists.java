package leetCode;

public class P21MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
        	return null;
        }
    	ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1!=null&&l2!=null){
	        if(l1.val>l2.val){
	        	temp.val=l2.val;
	        	l2=l2.next;
	        }else{
	        	temp.val=l1.val;
	        	l1=l1.next;
	        }
	        temp.next=new ListNode(0);
	        temp=temp.next;
        }
        
        while(l1!=null){
        	temp.val=l1.val;
        	l1=l1.next;
        	if(l1!=null)
        	temp.next = new ListNode(0);
        	temp=temp.next;
        }
        while(l2!=null){
        	temp.val=l2.val;
        	l2=l2.next;
        	if(l2!=null)
        	temp.next = new ListNode(0);
        	temp=temp.next;
        }
    	
    	return head;
    }	
    
    public static void main(String[] args) {
		
    	ListNode l1 = ListNode.constructALinkList("124");
    	ListNode l2 = ListNode.constructALinkList("134");
    	
    	ListNode.printLinkList(mergeTwoLists(l1,l2));
	}
}

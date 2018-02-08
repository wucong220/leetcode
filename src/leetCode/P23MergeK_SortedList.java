package leetCode;

public class P23MergeK_SortedList {
    static public ListNode mergeKLists(ListNode[] lists) {
        boolean flag=false;
    	for(ListNode l:lists){
        	if(l!=null){
        		flag=true;
        		break;
        	}
        }
    	if(!flag)return null;
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
		
	}
}

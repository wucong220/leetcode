package leetCode100;

import DataStructure.ListNode;

public class P160IntersectionofTwoLinkedLists {
    static public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    	ListNode ptr1 = headA;
    	ListNode ptr2 = headB;
    	while(ptr1!=null&&ptr2!=null){
    		ptr1=ptr1.next;
    		ptr2=ptr2.next;
    	}
    	
    	if(ptr1==null){
    		ListNode ptr22 = headB;
    		while(ptr2!=null){
    			ptr2=ptr2.next;
    			ptr22 = ptr22.next;
    		}
    		
    		ptr2 = ptr22;
    		ptr1 = headA;
    	}
    	else
    	{	
    		ListNode ptr11 = headA;
    		while(ptr1!=null){
    			ptr1=ptr1.next;
    			ptr11 = ptr11.next;
    		}
    		ptr1 = ptr11;
    		ptr2 = headB;
    	}
    	
    	while(ptr1!=null&&ptr2!=null){
    		if(ptr1==ptr2)return ptr1;
    		ptr1=ptr1.next;
    		ptr2=ptr2.next;
    	}
    	return null;
    }
    
    public static void main(String[] args) {
		ListNode l1 = ListNode.constructALinkList("1");
		ListNode l2 = ListNode.constructALinkList("1");
		System.out.println(getIntersectionNode(l1,l2));
	}
}

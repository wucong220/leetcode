package DataStructure;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    
    static public ListNode constructALinkList(String numbers){
    	ListNode head = null;
    	ListNode temp = null;
    	for(int i = 0;i<numbers.length();i++){
    		if(i==0){
    			head = new ListNode(Character.getNumericValue(numbers.charAt(i)));
    			temp = head;
    		}
    		else{
    			temp.next=new ListNode(Character.getNumericValue(numbers.charAt(i)));
    			temp = temp.next;
    		}
    	}
    	return head;
    }
    
    static public void printLinkList(ListNode head){
    	System.out.print(head.val);
    	while(null!=head.next){
    		System.out.print(" -> ");
    		System.out.print(head.next.val);
    		head = head.next;
    	}
    	System.out.println();
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return String.valueOf(val);
    }
}
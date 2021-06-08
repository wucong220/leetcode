package offer;

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
    
    public String toString(){
    	RandomListNode ptr = this.next;
		String s =this.label+"->";
    	while(ptr!=null&&ptr!=this){
			s+=ptr.label+"->";
			ptr=ptr.next;
		}
    	return s.substring(0,s.length()-2);
    		
    }
    
    
    public static void main(String[] args) {
		RandomListNode A = new RandomListNode(1);
		RandomListNode B = new RandomListNode(2);
		A.next=B;
		B.random = A;
		A.random = B;
		System.out.println(Clone(A));
		System.out.println(A);
	}
    
    //复杂链表复制
    static public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode ptr = pHead;  
        
        
        while(ptr!=null){
            RandomListNode temp = ptr.next;
            ptr.next = new RandomListNode(ptr.label+10);
            ptr.next.next = temp;
            ptr = temp;
        }
        
        ptr = pHead;
        while(ptr!=null){
        	 if(ptr.random!=null)
             ptr.next.random=ptr.random.next;
             ptr = ptr.next.next;
        }
        ptr = pHead;
        RandomListNode dummyHead = new RandomListNode(-1);
        RandomListNode ctail = dummyHead;
        while(ptr!=null){
            ctail.next = ptr.next;
            ctail=ptr.next;
            ptr.next = ptr.next.next;
            ptr = ptr.next;
        }
        return dummyHead.next;
    }
}
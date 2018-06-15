package leetCode;

import java.util.HashMap;

public class P146LRUCache {
	
}

class LRUCache {
	HashMap<Integer,Prior> keyValue;
	int capacity;
	int length=0;
	Prior head=new Prior(0,0,null,null);
	Prior tail=new Prior(0,0,null,null);
	
    public LRUCache(int capacity) {
        keyValue = new HashMap<>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
    	if(keyValue.containsKey(key)){
    		Prior p = keyValue.get(key);
    		goToHead(p);
    		return p.value;
    	}
     
    	else  return -1;
    }
    
    public void put(int key, int value) {
    	if(keyValue.containsKey(key)){
    		Prior p =keyValue.get(key);
    		p.value = value;
    		goToHead(p);
    	}else{
			Prior p = new Prior(key,value,null,null);
			keyValue.put(key, p);
			goToHead(p);
    		if(length==capacity){
    			removeTail();
    		}
    		else{
    			length++;
    		}
    	}
    }
    
    class Prior{
    	int key;
    	int value;
    	Prior pre;
    	Prior next;
		public Prior(int key, int value,  Prior pre,Prior next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
			this.pre = pre;
		}
    }
    
    public void goToHead(Prior p){
    	if(p.pre!=null)p.pre.next = p.next;
    	if(p.next!=null)p.next.pre = p.pre;
    	p.next = head.next;
    	p.pre = head;
    	head.next = p;
        p.next.pre = p;
    }
    public void removeTail(){
    	keyValue.remove(tail.pre.key);
    	tail.pre=tail.pre.pre;
    	tail.pre.next = tail;
    }
    
    public void removePrior(Prior p){
    	p.pre.next = p.next;
    	p.next.pre = p.pre;
    }
    
    public void printfuck(Prior p){
    	while(p!=null){
    		System.out.print(p.value+",");
    		p=p.next;
    	}
    	System.out.println(keyValue.keySet());
    }
}
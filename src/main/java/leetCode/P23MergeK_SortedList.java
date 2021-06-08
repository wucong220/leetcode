package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import DataStructure.ListNode;

public class P23MergeK_SortedList {
	static public ListNode mergeKLists(ListNode[] lists) {
	ListNode head = null;
		List<Integer> list = new ArrayList<Integer>();
    	for(ListNode l:lists){
    		while(null!=l){
    			list.add(l.val);
    			l=l.next;
    		}
    	}	
    	Collections.sort(list);
    	ListNode temp = null;
    	ListNode ex = null;
    	Iterator<Integer> i = list.iterator();
    	while(i.hasNext()){
    		temp = new ListNode(i.next());
    		if(null==head){
    			head = temp;
    		}
    		if(null!=ex){
    			ex.next=temp;
    		}
    		ex = temp;
    	}
    	
    	return head;
    }  
    
    public static void main(String[] args) {
		
	}
}

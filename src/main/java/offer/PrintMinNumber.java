package offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
    	Queue<Integer> q = new PriorityQueue<>((a,b)->compare(a,b));
    	for(int n:numbers)q.offer(n);
    	StringBuilder sb = new StringBuilder();
    	while(!q.isEmpty()){
    		sb.append(q.poll());
    	}
    	return sb.toString();
    }
    
    int compare(int a,int b){
    	String s1 = String.valueOf(a);
    	String s2 = String.valueOf(b);
    	
    	return Integer.parseInt(s1+s2) -Integer.parseInt(s2+s1);
    	
    }
}

package leetCode200;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P264 {
    public int nthUglyNumber(int n) {
    	int count=0;
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	Set<Integer> visited = new HashSet<>();
    	pq.add(1);
    	while(!pq.isEmpty()){
    		int curr=pq.poll();
    		count++;
    		if(count==n){
    			int fuck=0;
    			fuck+=curr;
    			//return fuck;
    		}
    		if(curr*2>0&&visited.add(curr*2))pq.offer(curr*2);
    		if(curr*3>0&&visited.add(curr*3))pq.offer(curr*3);
    		if(curr*5>0&&visited.add(curr*5))pq.offer(curr*5);
    	}
    	return 0;
    }
    public static void main(String[] args) {
		new P264().nthUglyNumber(1500);
    	//System.out.println(1399680000>Integer.m);
    }
}

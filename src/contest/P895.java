package contest;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P895 {
	
	
	public static void main(String[] args) {
		FreqStack fs = new FreqStack();
		fs.push(5);
		fs.push(7);
		fs.push(5);
		fs.push(7);
		fs.push(4);
		fs.push(5);
		fs.pop();
		fs.pop();
		fs.pop();
		fs.pop();
	}
}
class FreqStack {
	int time=0;
	Queue<Freq> pq = new PriorityQueue<>((a,b)->{
		if(b.freq!=a.freq)
		return b.freq-a.freq;
		else {
			return b.time.peek() -a.time.peek();
		}
	});
	Map<Integer,Freq> map = new HashMap<>();
	Deque<Integer> q = new LinkedList<>();
	
    public FreqStack() {
    	
    }
    
    public void push(int x) {
        q.push(x);
        if(!map.containsKey(x)){
        	map.put(x, new Freq(x,0,0));
        	pq.offer(map.get(x));
        }
        map.get(x).freq++;
        map.get(x).time.push(time++);
    }
    
    public int pop() {
    	Freq curr = pq.poll();
    	if(curr.freq==1){
    		map.remove(curr.key);
    	}
    	else{ 
    		curr.freq--;
    		curr.time.pop();
    		pq.offer(curr);
    	}
    	q.removeLastOccurrence(curr.key);
    	return curr.key;
    }
    
    class Freq{
    	int key;
    	Deque<Integer> time;
    	int freq;
    	Freq(int key,int index,int freq){
    		this.key = key;
    		this.time = new LinkedList<>();
    		this.freq =freq;
    	}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Freq [key=" + key + ", time=" + time + ", freq=" + freq + "]";
		}
    	
    }
}
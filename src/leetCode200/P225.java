package leetCode200;

import java.util.LinkedList;
import java.util.Queue;

public class P225 {

}

class MyStack {
	Queue<Integer> mQ;// = new LinkedList<>();
	Queue<Integer> sQ;// = new LinkedList<>();
	
    /** Initialize your data structure here. */
    public MyStack() {
    	mQ = new LinkedList<>();
    	sQ = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        this.mQ.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(mQ.size()>1){
        	sQ.offer(mQ.poll());
        }
        int ret;
        ret=mQ.poll();
        Queue<Integer> temp = sQ;
        sQ = mQ;
        mQ = temp;
        return ret;
    }
    
    /** Get the top element. */
    public int top() {
        while(mQ.size()>1){
        	sQ.offer(mQ.poll());
        }
        int ret;
        sQ.offer(ret=mQ.poll());
        Queue<Integer> temp = sQ;
        sQ = mQ;
        mQ = temp;
        return ret;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return mQ.isEmpty();
    }
}
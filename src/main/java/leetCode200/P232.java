package leetCode200;

import java.util.Stack;

public class P232 {
	public static void main(String[] args) {
		MyQueue m;
		(m = new MyQueue()).push(1);
		m.push(2);
		m.push(3);
		System.out.println(m.peek());
	}
}

class MyQueue {
	Stack<Integer> s;
	Stack<Integer> temp;

	/** Initialize your data structure here. */
	public MyQueue() {
		s = new Stack<>();
		temp = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		
		while (!s.isEmpty()) {
			temp.push(s.pop());
		}
		temp.push(x);
		while(!temp.isEmpty()){
			s.push(temp.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return s.pop();
	}

	/** Get the front element. */
	public int peek() {
		return s.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s.isEmpty();
	}
}
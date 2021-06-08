package leetCode200;

import java.util.LinkedList;
import java.util.Queue;

public class P227 {
	public int calculate(String s) {
		char[] ch = s.toCharArray();
		int first = 0, second = 0;
		char operator = 0;
		Queue<Character> que = new LinkedList<>();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				continue;
			} else {
				if (que.isEmpty()) {
					que.offer(ch[i]);
				} else {
					if (operator == 0) {
						if (ch[i] == '+' || ch[i] == '-') {
							first = calculate(que);
							que.clear();
							operator = ch[i];
						} else {
							que.offer(ch[i]);
						}
					}
					else{
						if (ch[i] == '+' || ch[i] == '-') {
							second = calculate(que);
							que.clear();
							
							if (operator == '+')
								first = first + second;
							else {
								first = first - second;
							}
							operator = ch[i];
						} else {
							que.offer(ch[i]);
						}
					}

				}
			}
		}
		if (operator == '+')
			return first + calculate(que);
		else if (operator == '-')
			return first - calculate(que);
		else
			return calculate(que);
	}

	private int calculate(Queue<Character> que) {
		// TODO Auto-generated method stub
		int first = 0;
		int second = 0;
		char operator = 0;
		while (!que.isEmpty()) {
			char c = que.poll();
			if (operator == 0) {
				if (c == '*' || c == '/')
					operator = c;
				else
					first = first * 10 + (c - '0');
			} else {
				if (c == '*') {
					if (operator == '*')
						first = first * second;
					else {
						first = first / second;
					}
					operator = '*';
					second=0;
				} else if (c == '/') {
					if (operator == '*')
						first = first * second;
					else {
						first = first / second;
					}
					operator = '/';
					second=0;
				} else {
					second = second * 10 + (c - '0');
				}
			}

		}
		if (operator == '*')
			return first * second;
		else if (operator == '/')
			return first / second;
		else
			return first;
	}

	public static void main(String[] args) {
		System.out.println(new P227().calculate("2*3*4"));
	}
}

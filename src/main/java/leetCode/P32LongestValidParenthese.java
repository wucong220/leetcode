package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class P32LongestValidParenthese {

	static public int longestValidParentheses(String s) {
		Deque<Integer> stack = new LinkedList<>(); // 存放左括号的索引。
		int start = -1; // 开始位置
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') { //遇到左括号
				stack.push(i);  //将左括号的索引压栈
			} else {    //遇到右括号
				if (stack.isEmpty()) { 
					start =  i;  //如果栈为空，将匹配位置设为i，开启新的匹配。
				}
				else{
					stack.pop();  //将左括号出栈
					if(stack.isEmpty()){
						max = Math.max(i-start, max);  //匹配完成
					}
					else{
						max = Math.max(i-stack.peek(), max); //部分匹配，还有括号未匹配
					}
					
				}
			}

		}

		return max;
	}

	public static void main(String[] args) {
		//String input = "((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((()())))(())()())((((()())((())))((()))()())))()(()()()(()((()))()()()))()()()(()()((((())()(((()(((())((()))()((()(()))()())))))))))())()())(()()))((()()()()())))((()()((((()()))))(())())()()))))(())()(()))((((((()))(()()()()(())(()((()))(()(())(((()()))(()((((()((((()((((())(())))()(())))()))(()((((((((())()()((())((()())()))))())())()(((((()()(((((())()((()(((()))(()(()))(()(()())))())(()((((()((()(((((()()))((()(()((())()))))(()(()())((()((()((((())))(()())()))()())())()))))(())))(())()((())(()(()))))()())(((()(()(((((((((()(()()())))((()((()())())())(((((()(()))))()))()))))()())()(()(())))(()))))(()))(((()))))())))))(((())((())((((()((()))((())))()))(((()))())()))()()()((()()(()())(()))()()((()())))))())(()())(((())))))())(())()))()())())(()(()((())((()(()((())(()()()(()((()(((()(())()(((())))))()())))))(()((((()(()()))(((())(()))(()()))))(())()((()))()))()()))()((())(()())())())(()))(()()(())()(()((((()())(((())(()()())())(()()))())))(()((())(()()))))(()))((()()((((()())(()()))()())()())))()(()((((())())()(())()))()()(()(()))))))(((()()((()))(()((((()()((())))())())))()())))())))((())()()()))()((()((()))()()())))(())())(()(()(()(()))())()))(())((())()())(((()()(((())(()()))(()())(())))()))(((()()()())))())))(((()))())())())))(((()))()())())())))))()()()()(())))(()())))(()()())))()((((()()()((((()))()())))(()))()))))(()())()))(((((())()((())()))(()())()()()())()(((()(()(())))))(()(((()()))((((()()))()))(((())(()(()))()(())))()()(()))))()))))()())))()))((((((((()()())((()(()()()(((())())())))()()(())(())))()())()())))((()))((((())()()))(())(((())(()()(((((()()((()()(((()(()()(((())()))))()(()())(()((((()()())(((()))(())((())()))))())))))(()()()())))()))(())((()())()())()()))(())))((()))()()((()())()()))(()()(())()())(())))((()(((())))()))))((((()))((())())())()(())(()))((((((())()()(((((()))()())(((()(()(())()((()())))(((())(()(())))))(()(()(((()))(())((((())))((())((((((((()(((((()(())))((((((())(()((((()(())()()((())())())((((((((()))))(((())()))()()))(())(())()()())(()()((())(()))())(((())(()((())(())(())))))(()(()(()()(((()()()))())(()))(())())()(((()((())((()())()(((((()()(()))))(((())()()))(()(()(()(()((())))))))(())())()))()(()(()))))()()((((())()())(((())(()))((()())(()((())()()(())((((())))))(())())())(())(()()(()()))(((()((((())(((())))))(()()()()(((()((((())(()))((())()))()(((((((()(()())))(((";
		String input = "(()()";
		System.out.println(longestValidParentheses(input));
	}

	/*
	 * 这个问题的精髓所在，是有效括号和有效括号之间是否能连成更大的有效括号
	 * 比如'()((())'，这个串中就有两个独立的有效括号子串'()'和'(())'
	 * 而在'()(())(',这个传中就有一整个大的有效括号之间串'()(())' 这个方法很好，可是逻辑很复杂，不适合系统的解。
	 */
	static public int longestValidParentheses1(String s) {

		int top = 0;
		int max = 0;

		LinkedList<Integer[]> lsp = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				top++;
			} else if (s.charAt(i) == ')') {
				top--;
				if (top == -1) {
					lsp.clear();
					top = 0;
					continue;
				}

				Integer[] sp = null;
				if (lsp.isEmpty()) {
					sp = new Integer[] { 2, top };
				} else {
					sp = lsp.pop();
					if (sp[1] == top + 1) {
						sp[0] += 2;
						sp[1]--;
						if (!lsp.isEmpty()) {
							Integer[] osp = lsp.pop();
							if (osp[1].equals(sp[1])) {
								sp[0] += osp[0];
							} else {
								lsp.push(osp);
							}
						}
					} else if (sp[1] == top) {
						sp[0] += 2;
					} else if (sp[1] < top) {
						lsp.push(sp);
						sp = new Integer[] { 2, top };
					}
				}
				max = Math.max(sp[0], max);
				lsp.push(sp);

			}
		}

		return max;
	}
}
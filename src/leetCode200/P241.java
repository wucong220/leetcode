package leetCode200;

import java.util.ArrayList;
import java.util.List;

public class P241 {
	public List<Integer> diffWaysToCompute(String input) {
		return diffWaysToCompute(input.toCharArray(), 0, input.length() - 1);
		
	}

	public List<Integer> diffWaysToCompute(char[] input, int left, int right) {
		List<Integer> li = new ArrayList<>();
		boolean flag=false;
		int sum=0;
		for (int i = left; i <= right; i++) {
			if (input[i] == '+' || input[i] == '-' || input[i] == '*') {
				for (int a : diffWaysToCompute(input, left, i - 1)) {
					for (int b : diffWaysToCompute(input, i + 1, right)) {
						li.add(compute(a, b, input[i]));
					}
				}
				flag=true;
			}
			sum=sum*10+input[i]-'0';
		}
		if(!flag){
			li.add(sum);
		}
		return li;
	}

	public int compute(int a, int b, char operator) {
		switch (operator) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return 0;

	}
	
	public static void main(String[] args) {
		System.out.println(new P241().diffWaysToCompute("2+3+4+5"));
		
		System.out.println(new int[]{1,2,3}.equals(new int[]{1,2,3}));
	}
}

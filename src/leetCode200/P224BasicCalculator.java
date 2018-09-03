package leetCode200;

import java.util.ArrayDeque;
import java.util.Deque;

public class P224BasicCalculator {
	public int calculate(String s) {
		char[] ch = s.toCharArray();
		int ret = 0;
		char operator = 'n';// Ã»ÓÐ²Ù×÷·û
		int number = 0;
		int oldNumber = 0;
		
		int top = 0;

		for (int i = 0; i < s.length();) {
			if (ch[i] >= '0' && ch[i] <= '9') {
				while (i<s.length()&&ch[i] >= '0' && ch[i] <= '9') {
					number = number*10+(ch[i]-'0');
					i++;
				}
				if (operator == 'n') {
					ret += number; 
				}
				else if(operator == '+'){
					ret = ret + number;
				}
				else if(operator == '-'){
					ret = ret - number;
				}
				number = 0;
			}
			else if(ch[i]=='+'){
				operator = '+';
				i++;
			}
			else if(ch[i]=='-'){
				operator = '-';
				i++;
			}
			else if(ch[i]=='('){
				top++;
				int oldi = i;
				i++;
				while(top!=0){
					if(ch[i]=='(')top++;
					else if(ch[i]==')')top--;
					i++;
				}
				number = calculate(s.substring(oldi+1,i-1));
				if (operator == 'n') {
					ret += number; 
				}
				else if(operator == '+'){
					ret = ret + number;
				}
				else if(operator == '-'){
					ret = ret - number;
				}
				number = 0;
				
			}
			else{
				i++;
			}
			
		}

		return ret;
	}
	public static void main(String[] args) {
		System.out.println(new P224BasicCalculator().calculate("2147483647"));
	}
}

package leetCode100;

import java.util.Stack;




public class P150EvaluateReversePolishNotation {
	public boolean isDigit(String s){
		Integer.parseInt("-1");
		r
	}
	
    public int evalRPN(String[] tokens) {
    	Stack<String> s = new Stack<>();
        for(int i=0;i<tokens.length;i++){
        	if(s.isEmpty())s.push(tokens[i]);
        	else{
        		if(Character.isDigit(tokens[i].charAt(0))||tokens[i].length()>1){
        			s.push(tokens[i]);
        		}
        		else{
        			int num2 = Integer.parseInt(s.pop());
        			int num1 = Integer.parseInt(s.pop());
        			switch(tokens[i].toCharArray()[0]){
        				case '+':
        					s.push(String.valueOf(num1+num2));
        					break;
        				case '-':
        					s.push(String.valueOf(num1-num2));
        					break;
        				case '*':
        					s.push(String.valueOf(num1*num2));
        					break;
        				case '/':
        					s.push(String.valueOf(num1/num2));
        					break;
        				default:
        					break;
        			}
        		}
        	}
        }
        
    	return Integer.parseInt(s.pop());     
    }
}

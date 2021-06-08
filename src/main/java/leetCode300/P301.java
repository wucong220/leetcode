package leetCode300;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P301 {
	public static void main(String[] args) {
		System.out.println(new P301().removeInvalidParentheses(")(()c))("));
	}
    public List<String> removeInvalidParentheses(String s) {
    	Deque<Integer> left_invalid=new LinkedList<>();
    	Deque<Integer> right_invalid=new LinkedList<>();
    	Deque<Integer> stack = new LinkedList<>();
    	char[] ch =s.toCharArray();
    	for(int i=0;i<ch.length;i++){
    		if(ch[i]=='(')stack.push(i);
    		else if(ch[i]==')'){
    			if(stack.isEmpty()){
    				right_invalid.add(i);
    			}
    			else{
    				stack.pop();
    			}
    		}
    	}
    	while(!stack.isEmpty()){
    		left_invalid.addFirst(stack.pop());
    	}
    	
    	
    	Set<String> lret = new HashSet<String>();
    	Set<String> rret = new HashSet<String>();
    	Set<String> ret = new HashSet<String>();
    	if(left_invalid.size()>0)
    	ldfs(lret, left_invalid, ch, ch.length-1, left_invalid.getFirst());
    	if(right_invalid.size()>0)
    	rdfs(rret, right_invalid, ch, 0, right_invalid.getLast());
    	String middle = s.substring(right_invalid.isEmpty()?0:right_invalid.getLast()+1,left_invalid.isEmpty()?ch.length:left_invalid.getFirst());
    	StringBuilder sb = new StringBuilder();
    	
    	if(lret.isEmpty()&&rret.isEmpty()){}
    	else if(lret.isEmpty())lret.add("");
    	else if(rret.isEmpty())rret.add("");
    	
    	for(String rstr:rret){
    		for(String lstr:lret){
    			ret.add(sb.append(rstr).append(middle).append(lstr).toString());
    			sb.delete(0, sb.length());
    		}	
    	}
    	
    	
    	if(ret.size()==0){
    		StringBuilder sb1 = new StringBuilder("");
    		if(!right_invalid.isEmpty())
    		for(int i=0;i<=right_invalid.getLast();i++){
    			if(ch[i]!='('&&ch[i]!=')')sb1.append(ch[i]);
    		}
    		sb1.append(middle);
    		if(!left_invalid.isEmpty())
    		for(int i=left_invalid.getFirst();i<ch.length;i++){
    			if(ch[i]!='('&&ch[i]!=')')sb1.append(ch[i]);
    		}
    		ret.add(sb1.toString());
    	}
    	return new ArrayList<>(ret);
    }
    
    public void ldfs(Set<String> lret,Deque<Integer> left,char[] ch,int index,int leftmost){
    	if(left.isEmpty()){
    		StringBuilder sb = new StringBuilder();
    		for(int i=leftmost;i<ch.length;i++){
    			if(ch[i]!='#'){
    				sb.append(ch[i]);
    			}
    		}
    		lret.add(sb.toString());
    		return;
    	}else if(index<leftmost)return;
    	int last=left.getLast();
    	for(int i=index;i>=last;i--){
    		if(ch[i]=='('){
    			ch[i]='#';
    			left.removeLast();
    			ldfs(lret, left,ch, i-1, leftmost);
    			left.addLast(last);
    			ch[i]='(';
    		}
    	}
    }
    
    public void rdfs(Set<String> rret,Deque<Integer> right,char[] ch,int index,int rightmost){
    	if(right.isEmpty()){
    		StringBuilder sb = new StringBuilder();
    		for(int i=0;i<=rightmost;i++){
    			if(ch[i]!='#'){
    				sb.append(ch[i]);
    			}
    		}
    		rret.add(sb.toString());
    		return;
    	}else if(index>rightmost)return;
    	int first=right.getFirst();
    	for(int i=index;i<=first;i++){
    		if(ch[i]==')'){
    			ch[i]='#';
    			right.removeFirst();
    			rdfs(rret, right,ch, i+1, first);
    			right.addFirst(first);
    			ch[i]=')';
    		}
    	}
    }
}

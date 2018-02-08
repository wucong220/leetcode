package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P20ValidParenthese {
	public boolean match(char a,char b){
		if((a=='('&&b==')')||
				(a=='['&&b==']')||
				(a=='{'&&b=='}')
				)
		return true;
		return false;
	}
	
	
    public boolean isValid(String s) {
        List<Character> list = new ArrayList<Character>();
        for(int i=0 ; i<s.length();i++){
        	if(list.size()>0&&match(list.get(list.size()-1), s.charAt(i))){
        		list.remove(list.size()-1);
        	}else{
        		list.add(s.charAt(i));
        	}
        }
        if(list.size()==0)
    	return true;
        return false;
    }
    
    public static void main(String[] args) {
		
	}
}

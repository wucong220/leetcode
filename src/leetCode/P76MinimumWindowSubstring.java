package leetCode;

import java.util.HashMap;
import java.util.Map;

public class P76MinimumWindowSubstring {
    public String MinWindow(String s, String t) {
    	Map<Character,Integer> t_index = new HashMap<>(t.length());
    	boolean[] t_used = new boolean[t.length()];
    	int lowest_index=0;
    	int highest_index=s.length()-1;
    	int low_index=0;
    	int high_index=s.length()-1;
    	int min_win_size=Integer.MAX_VALUE;
    	
    	int total_used=0;
    	for(int i = 0;i<t.length();i++){
    		t_index.put(t.charAt(i), i);
    	}
    	for(int i = 0;i<s.length();i++){
    		if(t_index.containsKey(s.charAt(i))){
    			int tindex= t_index.get(s.charAt(i));
    			if(t_used[tindex]==false){
    				total_used++;
    			}
    			if(tindex==low_index)
    			
    			
    		}
    	}
    	
    	return null;
    }
}

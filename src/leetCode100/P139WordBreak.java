package leetCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P139WordBreak {
    static public boolean wordBr1eak(String s, List<String> wordDict) {
    	boolean ret = false;
    	if(s.length()==0)
    		return true;
    	for(String prefix:wordDict){	
    		if(s.startsWith(prefix))
    		ret = ret||wordBreak(s.substring(prefix.length()),wordDict);
    		if(ret)return ret;
    	}
    	return ret;
    }
    
    static public boolean wordBreak(String s, List<String> wordDict){
    
    	for(String word :wordDict){
    		s.startsWith(word)
    	}
    	
    	return false;
    }
    public static void main(String[] args) {
    	String s = "dogs";
    	ArrayList<String> as = new ArrayList<>(Arrays.asList("dog","s","gs"));
    	System.out.println(wordBreak(s,as));
	}
}

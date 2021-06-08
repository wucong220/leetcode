package leetCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P140WordBreakII {
	//Time Limit Exceeded 暴力递归，总是超时
	//但是加上一个HashMap，作为结果的储存器，就能够通过，哦也
	
	public static List<String> wordBreak(String s,List<String> wordDict){
		Map<String,List<String>> cache = new HashMap<>();
		return wordBreak(s,wordDict,cache);
	}
	
	public static List<String> wordBreak(String s, List<String> wordDict,Map<String,List<String>> cache) {
		if(cache.containsKey(s))return cache.get(s);
		
		List<String> ret = new ArrayList<String>();
		if (s.length() == 0)
			return ret;
		for (String prefix : wordDict) {
			StringBuilder fuck = new StringBuilder(prefix);
			if (s.startsWith(prefix)) {
				if(s.length()==prefix.length()){ret.add(prefix);}
				for (String ls : wordBreak(s.substring(prefix.length()), wordDict,cache)) {
					fuck.append(" ").append(ls);
					ret.add(fuck.toString());
					fuck.delete(prefix.length(), fuck.length());
				}
			}
		}
		cache.put(s, ret);
		return ret;
	}

	public static void main(String[] args) {
		String s = "aaa";
		ArrayList<String> as = new ArrayList<>(Arrays.asList( "aa", "a"));
		System.out.println(wordBreak(s, as));
	}
}

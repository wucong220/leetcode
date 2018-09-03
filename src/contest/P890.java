package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
    	Map<Character,Character> biMap1 = new HashMap<>(),biMap2 = new HashMap<>();
    	List<String> ret = new ArrayList<>();
    	for(int i=0;i<words.length;i++){
    		for(int j=0;j<pattern.length();j++){
    			if(!bijection(biMap1,biMap2, words[i].charAt(j), pattern.charAt(j)))break;
    			if(j==pattern.length()-1)ret.add(words[i]);
    		}
    		biMap1.clear();
    		biMap2.clear();
    	}
    	return ret;
    }
    
    boolean bijection(Map<Character,Character> map1,Map<Character,Character> map2,Character a,Character b){
    	if(!map1.containsKey(a)&&!map2.containsKey(b)){
    		map1.put(a,b);
    		map2.put(b,a);
    		return true;
    	}
    	else if(map1.containsKey(a)&&map2.containsKey(b)){
    		if(map1.get(a)==b&&map2.get(b)==a)return true;
    		else return false;
    	}
    	else return false;
    }
    
    public static void main(String[] args) {
		System.out.println(new P890().findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"
				}, "abb"));
	}
}

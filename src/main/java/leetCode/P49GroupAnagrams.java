package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49GroupAnagrams {
    static public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> ret = new ArrayList<>();
    	Map<Map<Character,Integer>,Integer> smc = new HashMap<>();
    	int index_count=0;
    	for(int i = 0;i<strs.length;i++){
    		Map<Character,Integer> mc = new HashMap<>();
    		for(int j = 0;j<strs[i].length();j++){
    			char c = strs[i].charAt(j);
    			if(!mc.containsKey(c))
    				mc.put(c, 1);
    			else{
    				mc.put(c, mc.get(c)+1);
    			}
    		}
    		if(smc.containsKey(mc)){
    			int index=smc.get(mc);
    			List<String> ls = ret.get(index);
    			ls.add(strs[i]);
    			ret.set(index,ls);
    		}
    		else{
    			List<String> ls = new ArrayList<String>();
    			ls.add(strs[i]);
    			ret.add(ls);
    			smc.put(mc, index_count++);
    		}
    	}
    	
    	return ret;
    }	
    
    public static void main(String[] args) {
    	String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    	System.out.println(groupAnagrams(input));
	}
}

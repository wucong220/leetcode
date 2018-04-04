package leetCode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P127WordLadder {

	public List<String> findWords(String target, Set<String> dict) {
		char[] ch = target.toCharArray();
		List<String> ret = new ArrayList<>();
		for (char i = 'a'; i <= 'z'; i++) {
			for (int j = 0; j < target.length(); j++) {
				char old_ch = ch[j];
				if (ch[j] != i) {
					ch[j] = i;
					if (dict.contains(String.valueOf(ch))) {
						ret.add(String.valueOf(ch));
					}
				}
				ch[j] = old_ch;
			}
		}
		return ret;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	Queue<String> q = new LinkedList<>();
    	Set<String> dict = new HashSet<>(wordList);
    	Map<String,Integer> distance =new HashMap<>();
    	q.offer(beginWord);
    	distance.put(beginWord, 0);
    	while(!q.isEmpty()){
    		String cur = q.poll();
    		List<String> neigthbors = findWords(cur,dict);
    		for(String nei:neigthbors){    		
    			if(!distance.containsKey(nei)){
    				distance.put(nei,distance.get(cur)+1);
    			}
    			if(nei.equals(endWord))return distance.get(cur)+1;
    		}
    	}
		return 0;
    }
}

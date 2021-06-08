package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P30SubstringWithConcatenationOfAllWords2 {

	static public Map<String,Integer> countWords(String[] words){
		HashMap<String,Integer> words_count = new HashMap<String,Integer>();
		for(int i = 0;i<words.length;i++){
			if(words_count.containsKey(words[i])){
				words_count.put(words[i],words_count.get(words[i])+1);
			}
			else{
				words_count.put(words[i],1);
			}
		}
		return words_count;
	}
	
	
	
	static public boolean matchNextWord(String s, Map<String,Integer> words_count, int startWith, String preword) {
		boolean result = false;
		boolean flag = true; //if all words were used, then flag will be set to true;
		for (Iterator<String> iterator = words_count.keySet().iterator();iterator.hasNext();) {
			String word = iterator.next();
			if (words_count.get(word)==0)
				continue;
			else
				flag = false;
			int i = startWith + preword.length();
			if (s.startsWith(word, i)) {
				words_count.put(word,words_count.get(word)-1);
				if (matchNextWord(s, words_count, i, word)){
					result = true;
					words_count.put(word,words_count.get(word)+1);
					break;
				}
				else{
					words_count.put(word,words_count.get(word)+1);
				}
			}
			;
		}
		if(flag)return true;
		return result;
	}
	
	static public List<Integer> findSubstring(String s, String[] words) {
	//	boolean[] used = new boolean[words.length]; // 默认全部初始化为false
		List<Integer> ret = new ArrayList<Integer>();
//		Set<Integer> ret_set = new HashSet<Integer>();
		Map<String,Integer> words_count = countWords(words);
		Set<String>  wordsKey=words_count.keySet();
		
		
		int length_sum=0;
		for(int i = 0;i<words.length;i++){
			length_sum+=words[i].length();
		}
		
		
		for (int i = 0; i < s.length(); i++) {
			if(s.length()-i<length_sum)break;
			for (Iterator<String> iterator = wordsKey.iterator();iterator.hasNext();) {
				
				String word = iterator.next();
				if (s.startsWith(word, i)) {
					words_count.put(word,words_count.get(word)-1);
					if(matchNextWord(s, words_count, i, word)){
						ret.add(i);
					}
					words_count.put(word,words_count.get(word)+1);
				}
			}
		}
		//ret.addAll(ret_set);0
		return ret;
	}

	public static void main(String[] args) {
		String s = "barfoofoobarthefoobarman";
		String[] words = new String[] {"bar","foo","the" };
		System.out.println(findSubstring(s, words));
	}
}

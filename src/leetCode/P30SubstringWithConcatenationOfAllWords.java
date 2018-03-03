package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P30SubstringWithConcatenationOfAllWords {

	static public Map<String,Integer> countWords(String[] words){
		Map<String,Integer> words_count = new HashMap<String,Integer>();
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
	
	
	
	static public boolean matchNextWord(String s, String[] words_set, Integer[] words_value, int startWith, int index) {
		boolean result = false;
		boolean flag = true; //if all words were used, then flag will be set to true;
		for (int j = 0; j < words_set.length; j++) {
			if (words_value[j]==0)
				continue;
			else
				flag = false;
			int i = startWith + words_set[index].length();
			if (s.startsWith(words_set[j], i)) {
				words_value[j]--;
				if (matchNextWord(s, words_set, words_value, i, j)){
					result = true;
					words_value[j]++;
					break;
				}
				else{
					words_value[j]++;
				}
			}
			;
		}
		if(flag)return true;
		return result;
	}
	
	static public List<Integer> findSubstring(String s, String[] words) {
		//boolean[] used = new boolean[words.length]; // 默认全部初始化为false
		List<Integer> ret = new ArrayList<Integer>();
		Set<Integer> ret_set = new HashSet<Integer>();
		Map<String,Integer> word_count = countWords(words);
		
		
		String[] words_set = word_count.keySet().toArray(new String[]{});
		Integer[]  words_value = word_count.values().toArray(new Integer[]{});
		
		
		int length_sum=0;
		for(int i = 0;i<words.length;i++){
			length_sum+=words[i].length();
		}
		
		
		for (int i = 0; i < s.length(); i++) {
			if(s.length()-i<length_sum)break;
			for (int j = 0; j < words_set.length; j++) {
				if (s.startsWith(words_set[j], i)) {
					words_value[j]--;
					if(matchNextWord(s, words_set, words_value, i, j)){
						ret_set.add(i);
					}
					words_value[j]++;
				}
			}
		}
		ret.addAll(ret_set);
		return ret;
	}

	public static void main(String[] args) {
		String s = "barfoofoobarthefoobarman";
		String[] words = new String[] {"bar","foo","the" };
		System.out.println(findSubstring(s, words));
	}
}

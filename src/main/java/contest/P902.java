package contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P902 {
	public static void main(String[] args) {
		System.out.println(new P902().atMostNGivenDigitSet(new String[]{"1","3","5","7","8","9"},4653161));
	}
	
    public int atMostNGivenDigitSet(String[] D, int N) {
    	Map<Integer,Set<String>> map = new HashMap<>();
    	String strn = String.valueOf(N);
    	int digits = strn.length();
    	int count=0;
    	for(int i=1;i<=digits;i++){
    		count += atMostNGivenDigitSet(D, N,i,map).size();
    	}
    	return count;
    }

	private Set<String> atMostNGivenDigitSet(String[] d, int N, int digits,Map<Integer,Set<String>> map) {
		if(map.containsKey(digits))return map.get(digits);
		
		Set<String> set = new HashSet<>();
		if(digits==1){
			for(String s:d){
				if(s.charAt(0)-'0'<=N)
				set.add(s);
			}
			return set;
		}
		Set<String> subSet = atMostNGivenDigitSet(d, N, digits-1, map);
		for(String s:subSet){
			
			StringBuilder sb = new StringBuilder(s);
			for(int i=0;i<s.length();i++){
				for(String digit:d){
					sb.insert(i, digit);
					String temp;
					if(Long.parseLong(temp=sb.toString())<=N)
					set.add(temp);
					sb.deleteCharAt(i);
				}
			}
		}
		map.put(digits, set);
		return set;
	}
}

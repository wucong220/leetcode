package leetCode200;

import java.util.HashMap;
import java.util.Map;

public class P205IsomorphicStrings {
    static public boolean isIsomorphic(String s, String t) {
    	Map<Character,Character> map1 = new HashMap<>();
    	Map<Character,Character> map2 = new HashMap<>();
        StringBuilder sb1 = new StringBuilder(s.length());
        StringBuilder sb2 = new StringBuilder(t.length());
        char count1=0;
        char count2=0;
    	for(int i=0;i<s.length();i++){
        	Character c;
        	map1.putIfAbsent((c=s.charAt(i)), (char) ((count1++)+'a'));
        	sb1.append(map1.get(c));
        }
    	for(int i=0;i<t.length();i++){
        	Character c;
        	map2.putIfAbsent((c=t.charAt(i)), (char) ((count2++)+'a'));
        	sb2.append(map2.get(c));
        }
        return (sb1.toString()).equals(sb2.toString());
    }
    public static void main(String[] args) {
		System.out.println(isIsomorphic("aa", "ab"));
	}
}

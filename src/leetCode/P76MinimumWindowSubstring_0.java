package leetCode;

import java.util.HashMap;
import java.util.HashSet;

//来源：https://leetcode.com/problems/minimum-window-substring/discuss/26810/Java-solution.-using-two-pointers-+-HashMap
public class P76MinimumWindowSubstring_0 {

	public String minWindow(String s, String t) {
		if (s == null || s.length() < t.length() || s.length() == 0) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		int left = 0;
		int minLeft = 0;
		int minLen = s.length() + 1;
		int count = 0;
		for (int right = 0; right < s.length(); right++) {
			if (map.containsKey(s.charAt(right))) {
				map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
				if (map.get(s.charAt(right)) >= 0) {
					count++;
				}
				while (count == t.length()) {
					if (right - left + 1 < minLen) {
						minLeft = left;
						minLen = right - left + 1;
					}
					if (map.containsKey(s.charAt(left))) {
						map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
						if (map.get(s.charAt(left)) > 0) {
							count--;
						}
					}
					left++;
				}
			}
		}
		if (minLen > s.length()) {
			return "";
		}

		return s.substring(minLeft, minLeft + minLen);
	}

	public String minWindow1(String s, String t) {
		HashMap<Character, int[]> dic = new HashMap<>();

		for (char c : t.toCharArray()) {
			dic.merge(c, new int[] { 1, 0 }, (oldv, newv) -> {
				oldv[0]++;
				return oldv;
			});
		}
		char[] ch = s.toCharArray();
		int left = 0;
		int right = 0;
		int minleft = 0;
		int minright = 0;
		int minlen = Integer.MAX_VALUE;

		int sizeOfdic = t.length();
		int ctr = 0;

		while (true) {

			//right
			while (ctr < sizeOfdic) {
				if (dic.containsKey(ch[right])) {
					int[] in = dic.get(ch[right]);
					
					if (in[0] > in[1]) {
						in[1]++;
						ctr++;
					}
					else{
						
					}
					if (ctr == sizeOfdic) {
						if (minlen > right - left + 1) {
							minlen = right - left + 1;
							minleft = left;
							minright = right;
						}
					}
				}
				if(ctr==0){
					left++;
				}
				right++;
			}
			
			// left++
				
			

		}

		return null;
	}

}

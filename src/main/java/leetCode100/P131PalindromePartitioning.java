package leetCode100;

import java.util.ArrayList;
import java.util.List;

public class P131PalindromePartitioning {
	static public boolean isPalindrome(String s) {
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length / 2; i++) {
			if (!(cs[i] == cs[cs.length - 1 - i])) {
				return false;
			}
		}
		return true;
	}

	static public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			String curr = s.substring(0, i + 1);
			if (isPalindrome(curr)) {
				if (s.substring(i+1).length() == 0) {
					List<String> ls = new ArrayList<>();
					ls.add(curr);
					ret.add(ls);
				} else {
					List<List<String>> temp = partition(s.substring(i+1));
					for (List<String> ls : temp) {
						ls.add(0, curr);
						ret.add(ls);
					}
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		System.out.println(partition("aaaa"));
	}
}

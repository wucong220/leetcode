package string;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class RegexMatch {
	static public boolean match(char[] str, char[] pattern) {
		int i = 0;
		int j = 0;
		Deque<Integer> spi = new LinkedList<Integer>();
		Deque<Integer> spj = new LinkedList<Integer>();
		while (true) {
			while (i < str.length && j < pattern.length) {
				if (j == pattern.length - 1 || pattern[j + 1] != '*') {
					if (str[i] == pattern[j] || pattern[j] == '.') {
						i++;
						j++;
					} else {
						break;
					}
				} else {
					if (str[i] != pattern[j]&&pattern[j] != '.') {
						j += 2;
					} else {
						spi.add(i);
						spj.add(j);
						j += 2;
					}
				}
			}
			if (i == str.length &&(ok(pattern,j))){
					return true;
			}else if (!spi.isEmpty()) {
				i = spi.poll() + 1;
				j = spj.poll();
			} else
				return false;
		}
	}

	private static boolean ok(char[] pattern, int j) {
		for(int i =j;i<pattern.length;i++){
			if(pattern[i]!='*'&&(i==pattern.length-1||pattern[i+1]!='*'))return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(match("baccbbcbcacacbbc".toCharArray(), "c*.*b*c*ba*b*b*.a*".toCharArray()));
	}
}

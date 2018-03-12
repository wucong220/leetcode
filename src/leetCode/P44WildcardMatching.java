package leetCode;

public class P44WildcardMatching {

	// 超时，过度回溯
	static public String removeExtraStars(String p) {
		StringBuilder sb = new StringBuilder(p.length());
		for (int i = 0; i < p.length(); i++) {
			if (i < p.length() - 1 && p.charAt(i) == '*' && p.charAt(i + 1) == '*') {
				continue;
			}
			sb.append(p.charAt(i));
		}
		return sb.toString();
	}

	static public boolean isMatch(String s, String p) {
		p = removeExtraStars(p);
		return isMatch2(s, p);
	}

	static public boolean isMatch2(String s, String p) {

		if (s.length() < p.length() / 2)
			return false;
		int i = 0;
		int j = 0;
		int star = -1;
		int ss = 0;
		// System.out.println(p);
		while (i < s.length()) {
			if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j;
				ss = i;
				j++;
			} else if (star != -1) {
				j = star + 1;
				ss++;
				i = ss;
			} else
				return false;

		}
		
		if(j!=p.length()&&p.charAt(j)=='*')j++;
		
		if (i == s.length() && j == p.length())
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a*"));
	}
}

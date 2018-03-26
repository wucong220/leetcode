package leetCode;

import java.util.Arrays;

public class P97InterleavingString {

	// Time Limit Exceeded
	static public boolean isInterleave1(String s1, String s2, String s3) {
		int m = 0;
		int n = 0;
		for (int i = 0; i < s3.length(); i++) {
			if (m == s2.length() && n != s1.length()) {
				if (s1.charAt(n) == s3.charAt(i)) {
					n++;
				} else {
					return false;
				}
			} else if (n == s1.length() && m != s2.length()) {
				if (s2.charAt(m) == s3.charAt(i)) {
					m++;
				} else {
					return false;
				}
			} else if (m == s2.length() && n == s1.length()) {
				return false;
			} else {
				if ((s3.charAt(i) == s2.charAt(m)) && s3.charAt(i) != s1.charAt(n)) {
					m++;
				} else if (s3.charAt(i) != s2.charAt(m) && s3.charAt(i) == s1.charAt(n)) {
					n++;
				} else if (s3.charAt(i) == s2.charAt(m) && s3.charAt(i) == s1.charAt(n)) {
					return isInterleave1(s1.substring(n), s2.substring(m + 1), s3.substring(i + 1))
							|| isInterleave1(s1.substring(n + 1), s2.substring(m), s3.substring(i + 1));
				} else
					return false;
			}
		}
		if (n == s1.length() && m == s2.length())
			return true;
		return false;
	}

	static public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s2.length() + s1.length())
			return false;
		boolean[][] d = new boolean[s2.length() + 1][s1.length() + 1];
		d[0][0] = true;
		for (int i = 1; i <= s3.length(); i++) {
			for (int j = (i - s1.length()) > 0 ? (i - s1.length()) : 0; j <= s2.length() && j <= i; j++) {

				int k = i - j;
				if (i > 0 && j > 0 && k > 0 && s3.charAt(i - 1) == s2.charAt(j - 1)
						&& s3.charAt(i - 1) == s1.charAt(k - 1)) {
					d[j][k] = d[j - 1][k] || d[j][k - 1];
				} else if (i > 0 && j > 0 && s3.charAt(i - 1) == s2.charAt(j - 1)) {
					d[j][k] = d[j - 1][k];
				} else if (i > 0 && k > 0 && s3.charAt(i - 1) == s1.charAt(k - 1)) {
					d[j][k] = d[j][k - 1];
				}

				else if (i > 0 && j > 0 && k > 0 && s3.charAt(i - 1) != s2.charAt(j - 1)
						&& s3.charAt(i - 1) != s1.charAt(k - 1)) {
					d[j][k] = false;
				}
				System.out.println("i=" + i + "," + "j=" + j + "," + "k=" + k + "," + d[j][k]);
			}

		}
		return d[s2.length()][s1.length()];
	}

	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "bc";
		String s3 = "babc";
		System.out.println(isInterleave(s1, s2, s3));
	}
}

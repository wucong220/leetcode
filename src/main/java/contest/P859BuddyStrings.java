package contest;

import java.util.HashSet;
import java.util.Set;

public class P859BuddyStrings {
	public boolean buddyStrings(String A, String B) {
		if (A == null || B == null || A.length() != B.length())
			return false;
		else {
			int count = 0;
			boolean flag = false;
			int[] differA = { 0, 0 };
			int[] differB = { 0, 0 };
			Set<Character> s = new HashSet<Character>();
			for (int i = 0; i < A.length(); i++) {
				if (!flag) {
					if (s.contains(A.charAt(i))) {
						flag = true;
					} else {
						s.add(A.charAt(i));
					}
				}
				if (A.charAt(i) != B.charAt(i)) {
					if (count == 2) {
						return false;
					}
					differA[count] = A.charAt(i);
					differB[count++] = B.charAt(i);
				}
			}
			if ((differA[0] == differB[1] && differA[1] == differB[0] && count == 2) || (flag && count == 0))
				return true;
			else
				return false;
		}
	}
}

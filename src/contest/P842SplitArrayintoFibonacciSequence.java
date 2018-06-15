package contest;

import java.util.ArrayList;
import java.util.List;

public class P842SplitArrayintoFibonacciSequence {
	public static List<Integer> splitIntoFibonacci(String S) {
		List<Integer> ret = new ArrayList<Integer>();
		int n1;
		String S1 = new String(S);
		if (S1.charAt(0) == '0') {
			n1 = 0;
			ret.addAll(nextGeneration(S1.substring(1), -1, 0));
			if (!ret.isEmpty()) {
				ret.add(0, 0);
			}
		} else
			for (int i = 1; i < S1.length() + 1; i++) {
				
				long temp = Long.parseLong(S1.substring(0, i));
				if(temp>Integer.MAX_VALUE)break;
				n1 = Integer.parseInt(S1.substring(0, i));
				ret.addAll(nextGeneration(S1.substring(i), -1, n1));
				if (!ret.isEmpty()) {
					ret.add(0, n1);
					break;
				}
			}

		return ret;
	}

	static public List<Integer> nextGeneration(String S, int n1, int n2) {
		List<Integer> ret = new ArrayList<Integer>();
		if (S.length() == 0)
			return ret;
		if (n1 == -1) {
			if (S.charAt(0) == '0') {
				if (S.length() == 1) {
					ret.add(0);
				} else {
					ret.addAll(nextGeneration(S.substring(1), n2, 0));
					if (!ret.isEmpty()) {
						ret.add(0, 0);
					}
				}
			} else
				for (int i = 1; i < S.length() + 1; i++) {
					long temp = Long.parseLong(S.substring(0, i));
					if(temp>Integer.MAX_VALUE)break;
					int n3 = Integer.parseInt(S.substring(0, i));
					ret.addAll(nextGeneration(S.substring(i), n2, n3));
					if (!ret.isEmpty()) {
						ret.add(0, n3);
						break;
					}

				}
		} else {
			if (S.charAt(0) == '0') {
				if (n1 + n2 == 0) {
					if (S.length() == 1) {
						ret.add(0);
					} else {
						ret.addAll(nextGeneration(S.substring(1), n2, 0));
						if (!ret.isEmpty()) {
							ret.add(0, 0);
						}
					}
				}
			} else
				for (int i = 1; i < S.length() + 1; i++) {
					long temp = Long.parseLong(S.substring(0, i));
					if(temp>Integer.MAX_VALUE)break;
					int n3 = Integer.parseInt(S.substring(0, i));
					if (n1 + n2 == n3) {
						if (S.length() == i) {
							ret.add(n3);
							break;
						} else {
							ret.addAll(nextGeneration(S.substring(i), n2, n3));
							if (!ret.isEmpty()) {
								ret.add(0, n3);
								break;
							}
						}
					}
				}
		}

		return ret;
	}

	public static void main(String[] args) {
		System.out.println(splitIntoFibonacci("5511816597"));
	}
}

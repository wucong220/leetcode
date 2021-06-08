package contest;

import java.util.Stack;

public class P845LongestMountaininArray {
	static public int longestMountain(int[] A) {
		Stack<Integer> incline = new Stack<>();
		Stack<Integer> decline = new Stack<>();
		int max = 0;
		for (int i = 0; i < A.length; i++) {

			if (incline.empty()) {
				incline.push(A[i]);
			} else {
				int topi = incline.peek();
				if (topi > A[i]) {
					if (incline.size() >= 2) {
						if (decline.isEmpty()) {
							decline.push(A[i]);
						} else {
							int topd = decline.peek();
							if (topd > A[i]) {
								decline.push(A[i]);
							} else {
								max = Math.max(decline.size() + incline.size(), max);
								decline.clear();
								incline.clear();
								if (A[i] > topd)
									incline.push(topd);
								incline.push(A[i]);
							}
						}
					} else {
						incline.pop();
						incline.push(A[i]);
					}
				} else if (topi < A[i]) {
					if (decline.isEmpty()) {
						incline.push(A[i]);
					} else {
						max = Math.max(decline.size() + incline.size(), max);
						int topd = decline.pop();
						decline.clear();
						incline.clear();
						incline.push(topd);
						incline.push(A[i]);
					}
				} else {
					if ((!decline.empty()) && (!incline.empty())) {
						max = Math.max(decline.size() + incline.size(), max);
					}
					int topd = 0;
					if (!decline.empty())
						topd = decline.pop();
					decline.clear();
					incline.clear();
					if (!decline.empty())
						incline.push(topd);
					incline.push(A[i]);
				}
			}
		}

		if ((!decline.empty()) && (!incline.empty())) {
			max = Math.max(decline.size() + incline.size(), max);
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestMountain(new int[] { 875, 884, 239, 731, 723, 685 }));
	}
}

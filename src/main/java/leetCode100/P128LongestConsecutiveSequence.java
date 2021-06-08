package leetCode100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P128LongestConsecutiveSequence {

	// O(n)时间复杂度，找最长的连续数串。
	// 用最快的排序算法也需要O(nlogn)的时间复杂度
	// 也就是说不能对数组先排序再找；
	// 我灵光乍现
	// 可以使用一个终极好办法；
	//
	class LinkNode {
		int val;
		LinkNode pre;
		LinkNode next;
		boolean used = false;

		LinkNode(int val) {
			this.val = val;
		}
	}

	public int longestConsecutive(int[] nums) {
		Map<Integer, LinkNode> niceboy = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			if (!niceboy.containsKey(i)) {
				LinkNode littleI = new LinkNode(i);
				if (niceboy.containsKey(i - 1)) {
					LinkNode prenode = niceboy.get(i - 1);
					prenode.next = littleI;
					littleI.pre = prenode;
				}
				if (niceboy.containsKey(i + 1)) {
					LinkNode nextnode = niceboy.get(i + 1);
					nextnode.pre = littleI;
					littleI.next = nextnode;
				}
				niceboy.put(i, littleI);
			}
		}
		for (Integer i : niceboy.keySet()) {
			LinkNode curr = niceboy.get(i);
			if (!curr.used) {
				int count = 1;
				curr.used = true;
				LinkNode left = curr;
				while (left.pre != null) {
					count++;
					left = left.pre;
					left.used = true;
				}
				LinkNode right = curr;
				while (right.next != null) {
					count++;
					right = right.next;
					right.used = true;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}
}

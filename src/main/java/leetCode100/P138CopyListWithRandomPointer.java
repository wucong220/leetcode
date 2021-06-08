package leetCode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class P138CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		Queue<RandomListNode> q = new LinkedList<>();
		Queue<RandomListNode> q_clone = new LinkedList<>();
		Map<Integer, RandomListNode> node_set = new HashMap<>();
		RandomListNode clone = new RandomListNode(head.label);
		q_clone.offer(clone);
		node_set.put(clone.label, clone);
		q.offer(head);
		while (!q.isEmpty()) {
			RandomListNode curr = q.poll();
			RandomListNode curr_clone = q_clone.poll();

			RandomListNode neighbor_clone;
			if (curr.next != null) {
				if (!node_set.containsKey(curr.next.label)) {
					neighbor_clone = new RandomListNode(curr.next.label);
					node_set.put(curr.next.label, neighbor_clone);
					q.offer(curr.next);
					q_clone.offer(neighbor_clone);
				} else {
					neighbor_clone = node_set.get(curr.next.label);
				}
				curr_clone.next = (neighbor_clone);
			}
			if (curr.random != null) {
				if (!node_set.containsKey(curr.random.label)) {
					neighbor_clone = new RandomListNode(curr.random.label);
					node_set.put(curr.random.label, neighbor_clone);
					q.offer(curr.random);
					q_clone.offer(neighbor_clone);
				} else {
					neighbor_clone = node_set.get(curr.random.label);
				}
				curr_clone.random = (neighbor_clone);
			}
		}

		return clone;
	}
}

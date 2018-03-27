package leetCode;

import DataStructure.ListNode;

public class P02AddTwoNumbers {
	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode ret = new Solution().addTwoNumbers(l1, l2);
		System.out.println(ret.next);

	}

}


class Solution {

	public ListNode addTwoNumbersWithReminder(ListNode l1, ListNode l2, int remainder) {
		if (l1 == null && l2 == null && remainder == 0) {
			return null;
		}
		int value = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + remainder) % 10;
		remainder = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + remainder) / 10;
		ListNode ret = new ListNode(value);
		ret.next = addTwoNumbersWithReminder((l1 == null ? null : l1.next), (l2 == null ? null : l2.next), remainder);
		return ret;

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ret = addTwoNumbersWithReminder(l1, l2, 0);
		return ret;
	}
}
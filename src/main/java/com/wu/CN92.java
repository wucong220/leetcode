package com.wu;

import java.util.List;

/**
 * @author wuc006
 * @date 2021/3/18 9:24
 */
public class CN92 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode preHead = new ListNode(0);
            preHead.next = head;
            ListNode preLeft = preHead;
            for(int i=2;i<=left;i++){
                preLeft = preLeft.next;
            }
            ListNode tail = preLeft.next;
            ListNode curr = preLeft.next;
            for(int i=0;i<right-left+1;i++){
                ListNode temp = curr.next;
                curr.next = preLeft.next;
                preLeft.next = curr;
                curr = temp;
            }
            tail.next = curr;
            return preHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode.next = listNode2;
        RunUtil.run(listNode,1,2);
    }
}

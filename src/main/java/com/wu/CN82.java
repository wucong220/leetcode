package com.wu;

import java.util.concurrent.atomic.AtomicStampedReference;

public class CN82 {
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode preHead = new ListNode(0);
            preHead.next = head;
            ListNode ptr = preHead;
            while(ptr.next!=null&&ptr.next.next!=null){
                if(ptr.next.val==ptr.next.next.val){
                    ptr.next = findLastNext(ptr.next);
                }
                else{
                    ptr = ptr.next;
                }
            }
            return preHead.next;
        }

        public ListNode findLastNext(ListNode ptr){
            ListNode head = ptr;
            while(ptr.val==head.val){
                ptr = ptr.next;
            }
            return ptr;
        }
    }
}

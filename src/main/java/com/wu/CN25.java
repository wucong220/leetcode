package com.wu;

import java.util.Arrays;

public class CN25 {
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode preHead = new ListNode(0);
            preHead.next = head;
            ListNode tempPreHead = preHead;
            while (true) {
                ListNode temp = tempPreHead.next;
                if(temp==null)return preHead.next;
                for (int i = 0; i < k; i++) {
                    if (temp != null) {
                        temp = temp.next;
                    } else {
                        return preHead.next;
                    }
                }
                ListNode kTail = reverseK(tempPreHead, k);
                kTail.next = temp;
                tempPreHead = kTail;
            }
        }

        public ListNode reverseK(ListNode preHead,int k){
            ListNode ptr = preHead.next;
            ListNode tail = preHead.next;
            preHead.next = null;
            while(k>0&&ptr!=null){
                ListNode temp = ptr.next;
                ptr.next = preHead.next;
                preHead.next = ptr;
                ptr = temp;
                k--;
            }
            return tail;
        }
    }
}

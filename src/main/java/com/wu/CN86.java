package com.wu;

import java.util.List;

/**
 * @author wuc006
 * @date 2021/1/4 17:14
 */
public class CN86 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode ptr = head;
            ListNode ltxHead = new ListNode(0);
            ListNode ltxTail = ltxHead;
            ListNode gexHead = new ListNode(0);
            ListNode gexTail = gexHead;
            while(ptr!=null){
                if(ptr.val<x){
                    ltxTail.next = ptr;
                    ltxTail = ptr;
                }
                else{
                    gexTail.next = ptr;
                    gexTail = ptr;
                }
                ptr=ptr.next;
            }
            ltxTail.next = gexHead.next;
            gexTail.next = null;
            return ltxHead.next;
        }
    }
}

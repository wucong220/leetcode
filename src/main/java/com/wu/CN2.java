package com.wu;

/**
 * @author wuc006
 * @date 2020/8/21 9:21
 */
public class CN2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            head = plus(l1,l2);
            ListNode curr = head;
            int carry = curr.val/10;
            curr.val = curr.val%10;
            while(l1!=null||l2!=null){
                if(l1!=null)l1 = l1.next;
                if(l2!=null)l2 = l2.next;
                curr.next = plus(l1,l2);
                if(curr.next!=null){
                    curr=curr.next;
                    curr.val = curr.val + carry;
                    carry = curr.val/10;
                    curr.val = curr.val%10;
                }
                else{
                    if(carry>0){
                        ListNode listNode = new ListNode(carry);
                        curr.next = listNode;
                    }
                }
            }
            return head;
        }

        public ListNode plus(ListNode a, ListNode b){
            if(a==null&&b==null) return null;
            if(a==null)return b;
            if(b==null)return a;
            a.val = a.val+b.val;
            return a;
        }
    }
}

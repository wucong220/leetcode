package com.wu;

/**
 * @author wuc006
 * @date 2021/6/4 9:19
 */
public class CN160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode reversedA=reverse(headA);
            ListNode reversedB=reverse(headB);

            ListNode ptrA = reversedA;
            ListNode ptrB = reversedB;
            ListNode crossNode = null;
            while(ptrA==ptrB){
                crossNode = ptrA;
                ptrA=ptrA.next;
                ptrB=ptrB.next;
            }
            headA=reverse(reversedA);
            headB=reverse(reversedB);

            while(headA!=null){
                System.out.println(headA.val+",");
                headA = headA.next;
            }

            while(headB!=null){
                System.out.println(headB.val+",");
                headB = headB.next;
            }
            return crossNode;
        }

        private ListNode reverse(ListNode head) {
            ListNode preHead = new ListNode(0);
            while(head!=null){
                ListNode temp = head.next;
                head.next = preHead.next;
                preHead.next = head;
                head = temp;
            }
            return preHead.next;
        }
    }
}

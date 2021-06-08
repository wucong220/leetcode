package com.wu;

/**
 * @author wuc006
 * @date 2021/5/11 9:32
 */
public class CN143 {
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
        public void reorderList(ListNode head) {
            mergeSort(head);
        }

        /**
         * QuickSort
         * @param head
         */
        public ListNode quickSort(ListNode head) {
            if(head ==null )return null;
            ListNode ph1 = new ListNode(0);
            ListNode ph2 = new ListNode(0);
            ListNode ptr = head.next;
            while(ptr!=null){
                if(ptr.val<head.val){
                    ListNode temp = ptr.next;
                    ptr.next = ph1.next;
                    ph1.next = ptr;
                    ptr = temp;
                }
                else{
                    ListNode temp = ptr.next;
                    ptr.next = ph2.next;
                    ph2.next = ptr;
                    ptr = temp;
                }
            }
            ListNode ph = new ListNode(0);

            ph.next = quickSort(ph1.next);
            getTail(ph).next = head;
            head.next = quickSort(ph2.next);

            return ph.next;
        }

        /**
         * QuickSort
         * @param head
         */
        public ListNode mergeSort(ListNode head) {
            if(head ==null )return null;
            if(head.next ==null) return head;
            if(head.next.next==null){
                if(head.next.val<head.val){
                    head.next.next = head;
                    head= head.next;
                    head.next.next=null;
                }
                return head;
            }
            ListNode wk = head;
            ListNode rn = head;
            while(wk!=null&&rn!=null&&rn.next!=null){
                wk=wk.next;
                rn=rn.next.next;
            }
            ListNode l1 = mergeSort(wk.next);
            wk.next=null;
            ListNode l2 = mergeSort(head);

            ListNode ph = new ListNode(0);
            ListNode tail = ph;
            while(l1!=null&&l2!=null){
                if(l1.val<l2.val){
                    tail.next = l1;
                    tail = l1;
                    l1 = l1.next;
                }
                else{
                    tail.next = l2;
                    tail = l2;
                    l2 = l2.next;
                }
            }

            while(l1!=null){
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }

            while(l2!=null){
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }

            return ph.next;
        }

        private ListNode getTail(ListNode head){
            if(head==null)return null;
            while(head.next!=null){
                head = head.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-1);
        ListNode head = l1;
        l1 =l1.next =new ListNode(5);
        l1 =l1.next= new ListNode(3);
        l1 =l1.next= new ListNode(4);
        l1 =l1.next= new ListNode(0);
        new CN143().new Solution().mergeSort(head);
    }
}

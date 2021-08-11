package com.wu.sort;

import com.wu.ListNode;

import static com.wu.ListNodeUtil.getInts;
import static com.wu.ListNodeUtil.getListNode;

/**
 * @author wuc006
 * @date 2021/6/11 15:45
 */
public class QuickSortLinkedList {
    static void sort(int[] a) {
        ListNode head = getListNode(a);

        ListNode sorted = quickSort(head);

        int[] b = getInts(sorted);
        System.arraycopy(b, 0, a, 0, b.length);
    }

    static ListNode quickSort(ListNode root) {
        if(root==null||root.next==null)return root;
        ListNode left = new ListNode(1);
        ListNode right = new ListNode(2);
        ListNode ptr = root.next;
        root.next = null;
        while(ptr!=null){
            if(ptr.val<= root.val){
                ListNode temp = ptr.next;
                ptr.next = left.next;
                left.next = ptr;
                ptr = temp;
            }
            else{
                ListNode temp = ptr.next;
                ptr.next = right.next;
                right.next = ptr;
                ptr = temp;
            }
        }
        ListNode leftHead = quickSort(left.next);
        ListNode rightHead = quickSort(right.next);
        return connect(leftHead,root,rightHead);
    }

    private static ListNode connect(ListNode leftHead, ListNode root, ListNode rightHead) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
        ListNode ptr = leftHead;
        while(ptr!=null){
            tail.next = ptr;
            tail = ptr;
            ptr = ptr.next;
        }

        tail.next = root;
        tail = root;

        ptr = rightHead;
        while(ptr!=null){
            tail.next = ptr;
            tail = ptr;
            ptr = ptr.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        SortTest.run(QuickSortLinkedList::sort);
//        QuickSortLinkedList.sort(new int[]{18,9});
    }
}

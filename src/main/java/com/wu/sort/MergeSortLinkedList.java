package com.wu.sort;

import com.wu.ListNode;

import static com.wu.ListNodeUtil.getInts;
import static com.wu.ListNodeUtil.getListNode;

/**
 * @author wuc006
 * @date 2021/6/11 15:45
 */
public class MergeSortLinkedList {
    static void sort(int[] a) {
        ListNode head = getListNode(a);

        ListNode sorted = mergeSort(head);

        int[] b = getInts(sorted);
        System.arraycopy(b, 0, a, 0, b.length);
    }

    static ListNode mergeSort(ListNode root) {
        if(root==null||root.next==null)return root;
        if(root.next.next==null){
            ListNode temp = root.next;
            root.next=null;
            return merge(root,temp);
        }
        ListNode walker = root;
        ListNode runner = root;
        while (walker != null && runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode second = walker.next;
        walker.next=null;
        ListNode l1 = mergeSort(root);
        ListNode l2 = mergeSort(second);
        return merge(l1,l2);
    }

    static ListNode merge(ListNode first, ListNode second) {
        ListNode sorted = new ListNode(0);
        ListNode tail = sorted;
        while (first != null && second != null) {
            if (first.val < second.val) {
                tail.next = first;
                tail = first;
                first = first.next;
            } else {
                tail.next = second;
                tail = second;
                second = second.next;
            }
        }
        while (first != null) {
            tail.next = first;
            tail = first;
            first = first.next;
        }
        while (second != null) {
            tail.next = second;
            tail = second;
            second = second.next;
        }
        return sorted.next;
    }

    public static void main(String[] args) {
        SortTest.run(MergeSortLinkedList::sort);
    }
}

package com.wu.sort;

import com.wu.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.wu.ListNodeUtil.getInts;
import static com.wu.ListNodeUtil.getListNode;

/**
 * @author wuc006
 * @date 2021/6/11 15:45
 */
public class SelectSortLinkedList {
    static void sort(int[] a){
        ListNode head = getListNode(a);
        ListNode preHead = new ListNode(1);
        preHead.next = head;

        ListNode sorted = new ListNode(1);
        while(preHead.next!=null) {
            ListNode maxPreNode=preHead;
            int max = Integer.MIN_VALUE;
            for (ListNode ptr = preHead.next,preNode=preHead; ptr != null; preNode=ptr,ptr=ptr.next) {
                if(ptr.val>max){
                    max = ptr.val;
                    maxPreNode = preNode;
                }
            }
            ListNode temp = sorted.next;
            sorted.next = maxPreNode.next;
            maxPreNode.next = maxPreNode.next.next;
            sorted.next.next = temp;
        }

        int[] b = getInts(sorted.next);
        System.arraycopy(b,0,a,0,b.length);
    }

    public static void main(String[] args) {
        SortTest.run(SelectSortLinkedList::sort);
    }
}

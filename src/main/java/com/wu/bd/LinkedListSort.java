package com.wu.bd;

import com.wu.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/4/22 15:41
 */
public class LinkedListSort {
    public ListNode linkedListSort(ListNode root){
        ListNode odd = new ListNode(0);
        ListNode oddTail = odd;
        ListNode even = new ListNode(0);
        ListNode ptr = root;
        boolean isEvenNow = true;
        while(ptr!=null){
            ListNode temp = ptr.next;
            if(isEvenNow){
                ptr.next=even.next;
                even.next = ptr;
            }
            else{
                oddTail.next = ptr;
                oddTail=ptr;
                ptr.next = null;
            }
            isEvenNow=!isEvenNow;
            ptr = temp;
        }

        ListNode head = new ListNode(0);
        ptr = head;
        ListNode ptrOdd = odd.next;
        ListNode ptrEven = even.next;
        for(;ptrOdd!=null&&ptrEven!=null;ptrOdd=ptrOdd.next,ptrEven=ptrEven.next){
            if(ptrEven.val<ptrOdd.val){
                ptr.next = ptrEven;
            }
            else{
                ptr.next = ptrOdd;
            }
            ptr = ptr.next;
        }
        for(;ptrOdd!=null;ptrOdd=ptrOdd.next){
            ptr.next = ptrOdd;
            ptr = ptr.next;
        }
        for(;ptrEven!=null;ptrEven=ptrEven.next){
            ptr.next = ptrEven;
            ptr = ptr.next;
        }
        return head.next;
    }
}

package com.wu.sort;

import com.wu.ListNode;

import java.util.Arrays;

import static com.wu.ListNodeUtil.getInts;
import static com.wu.ListNodeUtil.getListNode;

/**
 * @author wuc006
 * @date 2021/6/11 15:45
 */
public class MergeSortLinkedListIterate {
    static void sort(int[] a) {
        ListNode head = getListNode(a);

        ListNode sorted = mergeSort(head);

        int[] b = getInts(sorted);
        System.arraycopy(b, 0, a, 0, b.length);
    }

    static ListNode mergeSort(ListNode root) {
        int ctr = 0;
        for(ListNode ptr = root;ptr!=null;ptr=ptr.next){
            ctr++;
        }
        ListNode hair = new ListNode(999);
        hair.next = root;

        for(int step=1;step<ctr;step*=2){
            ListNode pre = hair;
            for(ListNode curr = hair.next;curr!=null;){
                ListNode beforeMiddle = stepForward(curr,step-1);
                ListNode beforeNext=stepForward(curr,2*step-1);
                ListNode middle = beforeMiddle!=null?beforeMiddle.next:null;
                ListNode next = beforeNext!=null?beforeNext.next:null;
                if(beforeMiddle!=null)beforeMiddle.next=null;
                if(beforeNext!=null)beforeNext.next=null;
                curr = merge(curr, middle);
                beforeNext=stepForward(curr,2*step-1);
                if(beforeNext!=null)beforeNext.next=next;
                pre.next = curr;
                pre = beforeNext;
                curr = next;
            }
            int[] ints = getInts(hair.next);
            System.out.println(Arrays.toString(ints));
        }
        return hair.next;
    }

    private static ListNode stepForward(ListNode curr, int step) {
        for(int i=0;i<step&&curr!=null;i++){
            curr = curr.next;
        }
        return curr;
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
       SortTest.run(MergeSortLinkedListIterate::sort);
//        MergeSortLinkedListIterate.sort(new int[]{3, 17, 0, 11, 6, 11, 14});
    }
}

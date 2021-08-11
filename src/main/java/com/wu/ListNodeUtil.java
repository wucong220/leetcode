package com.wu;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wuc006
 * @date 2021/6/15 17:27
 */
public class ListNodeUtil {
    public static int[] getInts(ListNode sorted) {
        List<Integer> list = new LinkedList<>();
        for(ListNode ptr = sorted; ptr!=null; ptr=ptr.next){
            list.add(ptr.val);
        }
        int[] b = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    public static ListNode getListNode(int[] a) {
        ListNode preHead = new ListNode(1);
        ListNode pre = preHead;
        for (int j : a) {
            ListNode curr = new ListNode(j);
            pre.next = curr;
            pre = curr;
        }
        return preHead.next;
    }
}

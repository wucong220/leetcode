package com.wu;

import com.sun.imageio.plugins.jpeg.JPEGImageReaderResources;

/**
 * @author wuc006
 * @date 2021/4/23 15:20
 */
public class CN25_1 {
        class Solution {
            public ListNode reverseKGroup(ListNode head, int k) {
                ListNode h = new ListNode(1);
                h.next = head;
                ListNode ptr = head;
                ListNode kPreHead = h;
                while (true) {
                    int i = 0;
                    for (; i < k && ptr != null; i++) {
                        ptr = ptr.next;
                    }
                    if (!(i == k)) {
                        break;
                    }

                    ListNode kAfterTail = ptr;
                    ListNode tail = reverseK(kPreHead, k);
                    tail.next = kAfterTail;
                    kPreHead = tail;
                }
                return h.next;
            }

            private ListNode reverseK(ListNode kPreHead, int k) {
                ListNode tail = kPreHead.next;
                ListNode ptr = kPreHead.next;
                kPreHead.next = null;
                for(int i=0;i<k;i++){
                    ListNode temp = ptr.next;
                    ptr.next = kPreHead.next;
                    kPreHead.next = ptr;
                    ptr = temp;
                }
                return tail;
            }
        }
}

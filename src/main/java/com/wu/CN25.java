package com.wu;

import com.sun.imageio.plugins.jpeg.JPEGImageReaderResources;

/**
 * @author wuc006
 * @date 2021/4/23 15:20
 */
public class CN25 {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode preHead = new ListNode(0);
            preHead.next=head;
            ListNode tempPreHead = preHead;
            while(true){
                ListNode ptr = tempPreHead.next;
                int ctr=0;
                while(ptr!=null){
                    ctr++;
                    if(ctr==k)break;
                    ptr = ptr.next;
                }
                if(ctr<k)break;
                ListNode tailNext = ptr.next;
                ListNode tail = tempPreHead.next;
                reverseK(tempPreHead,k);
                tail.next = tailNext;
                tempPreHead = tail;
            }
            return preHead.next;
        }

        private void reverseK(ListNode preHead, int k) {
            ListNode ptr = preHead.next;
            preHead.next = null;
            for(int i=0;i<k;i++){
                ListNode temp = ptr.next;
                ptr.next = preHead.next;
                preHead.next = ptr;
                ptr=temp;
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        RunUtil.run(l1,2);
    }
}

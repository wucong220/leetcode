package com.wu;

import lombok.Data;

/**
 * @author wuc006
 * @date 2020/8/21 9:21
 */
@Data
public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) { val = x; }
}
